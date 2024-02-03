package com.springexamp.exceptionhandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Report not found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String iaException() {
        return "Wrong parameter";
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Report not found";
    }
}
