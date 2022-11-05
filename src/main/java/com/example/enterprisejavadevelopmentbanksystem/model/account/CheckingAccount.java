package com.example.enterprisejavadevelopmentbanksystem.model.account;
import javax.persistence.Entity;


@Entity
public class CheckingAccount extends Account {



    public CheckingAccount(String secretKey) {
        super(secretKey);
    }
    public CheckingAccount() {

    }


}
