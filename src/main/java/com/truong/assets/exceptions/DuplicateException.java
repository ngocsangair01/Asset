package com.truong.assets.exceptions;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
