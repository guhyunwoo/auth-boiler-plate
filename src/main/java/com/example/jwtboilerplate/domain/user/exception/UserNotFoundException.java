package com.example.jwtboilerplate.domain.user.exception;

import com.example.jwtboilerplate.global.error.ErrorCode;
import com.example.jwtboilerplate.global.error.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
