package com.example.jwtboilerplate.global.security.jwt.exception;

import com.example.jwtboilerplate.global.error.exception.BusinessBaseException;
import com.example.jwtboilerplate.global.error.ErrorCode;

public class ExpiredJwtTokenException extends BusinessBaseException {
  public static final BusinessBaseException EXCEPTION =
          new ExpiredJwtTokenException();

  private ExpiredJwtTokenException() { super(ErrorCode.EXPIRED_JWT); }
}