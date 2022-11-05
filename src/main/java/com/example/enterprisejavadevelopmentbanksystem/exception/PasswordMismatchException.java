package com.example.enterprisejavadevelopmentbanksystem.exception;

public class PasswordMismatchException extends RuntimeException {


    public PasswordMismatchException() {
        super("Incorrect Password or SecretKey");
    }
}