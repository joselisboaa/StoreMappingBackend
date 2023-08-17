package com.map.store.api.exception;

import com.map.store.domain.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handler(Exception exception) {
        final String ERROR_MSG = "Ocorreu um erro no servidor";
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError error = new StandardError(ERROR_MSG, exception.getMessage());

        return ResponseEntity.status(httpStatus).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception) {
        final String ERROR_MSG = "Não encontrado na base de dados";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(ERROR_MSG, exception.getMessage());

        return ResponseEntity.status(httpStatus).body(error);
    }
}
