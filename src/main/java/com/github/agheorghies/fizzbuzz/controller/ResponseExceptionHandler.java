package com.github.agheorghies.fizzbuzz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e) {
        return handleRuntimeException(e.getMessage()+" - expected integer value", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return handleRuntimeException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleMissingServletRequestParameterException(NullPointerException e) {
        return handleRuntimeException("Missing expected parameters", HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> handleRuntimeException(String errMessage, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", errMessage);

        return new ResponseEntity<>(response, status);
    }
}
