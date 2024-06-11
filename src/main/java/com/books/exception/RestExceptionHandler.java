package com.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<String> bookNotFound(BookNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
    }
}
