package com.example.dayThree.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AopIsAwesomeHeaderException extends RuntimeException{
    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
}
