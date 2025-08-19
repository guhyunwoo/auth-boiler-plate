package com.example.jwtboilerplate.global.error.exception;


import com.example.jwtboilerplate.global.error.ErrorCode;

public class AlreadyExistsException extends BusinessBaseException {
    public AlreadyExistsException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }

    public AlreadyExistsException(String message) {
        super(ErrorCode.ALREADY_EXISTS);
    }
}
