package com.example.enterprisejavadevelopmentbanksystem.model.account;

import javax.persistence.Entity;

@Entity
public class StudentCheckingAccount extends Account{
    public StudentCheckingAccount(String secretKey) {
        super (secretKey);
    }

    public StudentCheckingAccount() {
    }
}
