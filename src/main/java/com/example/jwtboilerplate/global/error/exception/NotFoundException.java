package com.example.jwtboilerplate.global.error.exception;

import com.example.jwtboilerplate.global.error.ErrorCode;

public class NotFoundException extends BusinessBaseException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }
}
