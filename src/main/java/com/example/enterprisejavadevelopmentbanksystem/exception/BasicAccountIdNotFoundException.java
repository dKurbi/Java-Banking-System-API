package com.example.enterprisejavadevelopmentbanksystem.exception;

public class BasicAccountIdNotFoundException extends RuntimeException {

    public BasicAccountIdNotFoundException(Long id) {
        super("The Account Holder User id: " + id + " is not found");
    }
}
