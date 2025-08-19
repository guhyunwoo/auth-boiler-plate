package com.example.jwtboilerplate.domain.user.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.example.jwtboilerplate.domain.user.dto.UserLoginRequest;
import com.example.jwtboilerplate.domain.user.dto.UserRegisterRequest;
import com.example.jwtboilerplate.domain.user.exception.InvalidPasswordException;
import com.example.jwtboilerplate.domain.user.exception.UserAlreadyExistsException;
import com.example.jwtboilerplate.domain.user.domain.User;
import com.example.jwtboilerplate.domain.user.exception.UserNotFoundException;
import com.example.jwtboilerplate.domain.user.repository.UserRepository;
import com.example.jwtboilerplate.global.security.jwt.TokenProvider;
import com.example.jwtboilerplate.global.security.util.CookieManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final CookieManager cookieManager;
    private final RedisTemplate<String, String> redisTemplate;
    private static final String REDIS_REFRESH_KEY_PREFIX = "refreshToken:";

    @Transactional
    public void createUser(UserRegisterRequest req) {
        if (userRepository.existsByEmail(req.email())) throw new UserAlreadyExistsException();

        String password = passwordEncoder.encode(req.password());

        User user = User.newInstance(req, password);

        userRepository.save(user);
    }
  
    public void login(UserLoginRequest req, HttpServletResponse res) {
        String email = req.email();

        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if(!passwordEncoder.matches(req.password(), user.getPassword())) throw new InvalidPasswordException();

        String accessToken = tokenProvider.createAccessToken(email);
        String refreshToken = tokenProvider.createRefreshToken(email);

        redisTemplate.opsForValue().set(REDIS_REFRESH_KEY_PREFIX+email, refreshToken);

        cookieManager.setAuthorizationHeader(res, accessToken);
        cookieManager.setRefreshTokenCookie(res, refreshToken);
    }

    public void refresh(Cookie cookie, HttpServletResponse res) {
        cookieManager.setAuthorizationHeader(res, tokenProvider.refresh(cookie));
    }

    public void logout(HttpServletResponse res) {
        cookieManager.clearCookie(res);
        cookieManager.clearAuthorizationHeader(res);
    }
}
