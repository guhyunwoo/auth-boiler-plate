package com.example.jwtboilerplate.global.security.jwt.exception;

import com.example.jwtboilerplate.global.error.ErrorCode;
import com.example.jwtboilerplate.global.error.exception.BusinessBaseException;

public class RefreshTokenNotFoundException extends BusinessBaseException {
    public static final BusinessBaseException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() { super(ErrorCode.REFRESH_TOKEN_NOT_FOUND); }
}