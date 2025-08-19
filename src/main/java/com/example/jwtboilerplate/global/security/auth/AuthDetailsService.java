package com.example.jwtboilerplate.global.security.auth;

import com.example.jwtboilerplate.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.jwtboilerplate.domain.user.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AuthDetails(
                userRepository.findByEmail(email)
                        .orElseThrow(UserNotFoundException::new)
        );
    }
}
