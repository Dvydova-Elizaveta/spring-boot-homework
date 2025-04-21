package com.example.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex){
        String errorMessage = "Custom 502 Error: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_GATEWAY);
    }
}
