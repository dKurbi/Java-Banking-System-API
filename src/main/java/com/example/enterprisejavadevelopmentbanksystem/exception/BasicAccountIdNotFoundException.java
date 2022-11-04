package com.example.enterprisejavadevelopmentbanksystem.exception;

public class BasicAccountIdNotFoundException extends RuntimeException {

    public BasicAccountIdNotFoundException(Long id) {
        super("The Basic account with id: " + id + " is not found");
    }
}
