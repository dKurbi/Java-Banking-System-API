package com.example.enterprisejavadevelopmentbanksystem.model.account;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CreditCard extends BasicAccount {

    //--------------Attributes
    private BigDecimal interestRate;


    //-------------Constructors
    public CreditCard() {
    }
}
