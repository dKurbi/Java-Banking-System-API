package com.example.enterprisejavadevelopmentbanksystem.model.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public abstract class Account extends BasicAccount{

//---------------Attributes

    private String secretKey;

    private AccountStatus status;



//--------------Constructors


    public Account(LocalDateTime creationDate, String secretKey) {
        super(creationDate);
        this.secretKey = secretKey;
    }


    public Account() {
    }

}
