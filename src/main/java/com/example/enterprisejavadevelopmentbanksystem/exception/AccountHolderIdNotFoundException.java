package com.example.enterprisejavadevelopmentbanksystem.exception;

public class AccountHolderIdNotFoundException extends RuntimeException {

    public AccountHolderIdNotFoundException(Long id) {
        super("The Account Holder User id: " + id + " is not found");
    }
}
