package com.github.agheorghies.fizzbuzz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", e.getMessage()+" - expected integer value");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
