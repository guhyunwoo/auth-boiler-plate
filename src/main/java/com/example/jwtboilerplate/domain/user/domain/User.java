package com.example.jwtboilerplate.domain.user.domain;

import com.example.jwtboilerplate.domain.user.dto.UserRegisterRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;
    // 닉네임 중복 X

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    public static User newInstance(UserRegisterRequest req, String password) {
        return new User(req, password);
    }

    public User(UserRegisterRequest req, String password) {
        this.username = req.username();
        this.password = password;
        this.email = req.email();
    }
}