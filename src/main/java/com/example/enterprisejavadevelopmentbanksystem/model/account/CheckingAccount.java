package com.example.enterprisejavadevelopmentbanksystem.model.account;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
public class CheckingAccount extends Account {

    /**------------------------------------------Constructors---------------------------------------------**/


    /**
     * Create account with Owner, default Currency (EUR) and secret key
     **/
    public CheckingAccount(AccountHolderUser owner, String secretKey) {
        super(owner, secretKey);
    }

    /**
     * Create account with Owner, specific Currency and secret key
     **/
    public CheckingAccount(AccountHolderUser owner, Currency currency, String secretKey) {
        super(owner, currency, secretKey);

    }

    /**
     * Create account with Owner, secondary Owner, default currency (EUR) and secret key
     **/
    public CheckingAccount(AccountHolderUser owner, AccountHolderUser secondaryOwner, String secretKey) {
        super(owner, secondaryOwner, secretKey);

    }


    /**
     * Create account with Owner, secondary Owner, specific currency and secret key
     **/
    public CheckingAccount(AccountHolderUser owner, AccountHolderUser secondaryOwner, Currency currency, String secretKey) {
        super(owner, secondaryOwner, currency, secretKey);
    }


    public CheckingAccount() {

    }


}
