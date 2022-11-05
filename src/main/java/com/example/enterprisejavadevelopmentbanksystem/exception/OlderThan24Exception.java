package com.example.enterprisejavadevelopmentbanksystem.exception;

public class OlderThan24Exception extends RuntimeException {
    public OlderThan24Exception(Long ownerAge, Long ownerId) {
        super("The User with Id :" + ownerId + " is " + ownerAge + "  and is not allowed to create a Student Checking Account");
    }
}
