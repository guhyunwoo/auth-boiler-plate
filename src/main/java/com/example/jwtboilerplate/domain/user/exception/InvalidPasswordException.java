package com.example.jwtboilerplate.domain.user.exception;

import com.example.jwtboilerplate.global.error.ErrorCode;
import com.example.jwtboilerplate.global.error.exception.BusinessBaseException;

public class InvalidPasswordException extends BusinessBaseException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
