package com.example.jwtboilerplate.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRegisterRequest(
        @Size(min = 1, max = 15, message = "닉네임은 최소 1자 이상, 최대 15자 이하여야 합니다.")
        @NotBlank(message = "닉네임은 필수입니다.")
        String username,

        @Size(min = 8,  max = 20, message = "비밀번호는 최소 8자 이상, 최대 20자 이하여야 합니다.")
        @NotBlank(message = "비밀번호는 필수입니다.")
        String password,

        @Size(min = 11, max = 255, message = "이메일은 최소 11자 이상, 최대 255자 이하여야 합니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @NotBlank(message = "이메일은 필수입니다.")
        String email,

        @NotBlank(message = "생년월일은 필수입니다.")
        LocalDate birthDate,

        Boolean gender // true : 남성, false : 여성
) { }
