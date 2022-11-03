package com.example.enterprisejavadevelopmentbanksystem.exception;

public class SecondaryOwnerIdNotFoundException extends RuntimeException {
    public SecondaryOwnerIdNotFoundException(Long id) {
        super("The Secondary Owner Account Holder User id: " + id + " is not found");
    }
}
