package com.example.jwtboilerplate.domain.user.controller;

import com.example.jwtboilerplate.domain.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.example.jwtboilerplate.domain.user.dto.UserLoginRequest;
import com.example.jwtboilerplate.domain.user.dto.UserRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterRequest req) {
        userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginRequest req, HttpServletResponse res) {
        userService.login(req, res);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<Void> refresh(@CookieValue(value = "refresh_token") Cookie cookie, HttpServletResponse res) {
        userService.refresh(cookie, res);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(HttpServletResponse res) {
        userService.logout(res);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
