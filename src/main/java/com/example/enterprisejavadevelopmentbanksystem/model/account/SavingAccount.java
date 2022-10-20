package com.example.enterprisejavadevelopmentbanksystem.model.account;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class SavingAccount extends Account {

    //---------Attributes

    private BigDecimal interestRate;

    //-------------Constructors


    public SavingAccount() {
    }
}
