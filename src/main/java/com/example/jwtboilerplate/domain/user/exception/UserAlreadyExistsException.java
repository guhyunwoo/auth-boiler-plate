package com.example.jwtboilerplate.domain.user.exception;

import com.example.jwtboilerplate.global.error.ErrorCode;
import com.example.jwtboilerplate.global.error.exception.AlreadyExistsException;

public class UserAlreadyExistsException extends AlreadyExistsException {
    public UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
