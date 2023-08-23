package com.oguzhankaratas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED) // 401:yetkisiz giriş
public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String message) {super(message);}
}
