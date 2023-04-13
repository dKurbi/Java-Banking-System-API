package com.example.enterprisejavadevelopmentbanksystem.exception;

import com.example.enterprisejavadevelopmentbanksystem.dto.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=RuntimeException.class )
    protected ResponseEntity<ResponseError> runtimeException (RuntimeException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseError.builder().errorDescription(e.getMessage()).build());
    }
}
