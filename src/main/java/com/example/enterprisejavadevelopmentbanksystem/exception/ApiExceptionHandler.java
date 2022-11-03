package com.example.enterprisejavadevelopmentbanksystem.exception;

import com.example.enterprisejavadevelopmentbanksystem.dto.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=RuntimeException.class )
    protected ResponseEntity<ResponseError> runtimeException (RuntimeException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseError.builder().errorDescription(e.getMessage()).build());
    }
}
