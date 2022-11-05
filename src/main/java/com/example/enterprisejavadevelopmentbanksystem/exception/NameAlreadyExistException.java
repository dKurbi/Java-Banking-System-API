package com.example.enterprisejavadevelopmentbanksystem.exception;

public class NameAlreadyExistException extends RuntimeException {
    public NameAlreadyExistException(String name) {
    super("A user with the name '" + name +"' is already exist");
    }
}
