package com.example.enterprisejavadevelopmentbanksystem.exception;

public class OwnerIdMismatchException extends RuntimeException {
    public OwnerIdMismatchException(Long ownerId) {
        super("The ownerId of the account is not: " + ownerId );
    }
}
