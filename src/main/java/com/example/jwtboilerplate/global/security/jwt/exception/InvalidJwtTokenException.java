package com.example.jwtboilerplate.global.security.jwt.exception;

import com.example.jwtboilerplate.global.error.exception.BusinessBaseException;
import com.example.jwtboilerplate.global.error.ErrorCode;

public class InvalidJwtTokenException extends BusinessBaseException {
  public static final BusinessBaseException EXCEPTION =
          new InvalidJwtTokenException();

  private InvalidJwtTokenException() { super(ErrorCode.INVALID_JWT); }
}
