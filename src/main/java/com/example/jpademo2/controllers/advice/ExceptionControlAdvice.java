package com.example.jpademo2.controllers.advice;

import com.example.jpademo2.dto.MessageDetails;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControlAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageDetails> handleRuntimeException(RuntimeException ex) {
        MessageDetails msg = new MessageDetails(ex.getMessage());
        return ResponseEntity.internalServerError().body(msg);
    }
}
