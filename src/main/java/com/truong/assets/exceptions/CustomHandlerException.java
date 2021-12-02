package com.truong.assets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomHandlerException {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorRespone handleNotFoundException(NotFoundException exception, WebRequest request) {
        return new ErrorRespone(exception.getMessage());
    }
    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRespone handleDuplicateException(DuplicateException exception, WebRequest request) {
        return new ErrorRespone(exception.getMessage());
    }
}
