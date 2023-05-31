package com.gomezvinuesamario.controller.exception;

import com.gomezvinuesamario.controller.exception.custom.NotFoundException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(final NotFoundException ex, final WebRequest request) {
        final ErrorMessage message = new ErrorMessage(ex.getMessage());

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
