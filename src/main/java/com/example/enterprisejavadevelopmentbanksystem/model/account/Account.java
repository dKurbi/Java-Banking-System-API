package com.example.enterprisejavadevelopmentbanksystem.model.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountStatus;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Getter
@Setter
public abstract class Account extends BasicAccount{

/**-----------------------------------Attributes-----------------------------------**/

    private String secretKey;

    private AccountStatus status;



    /**--------------------------------Constructors---------------------------------**/
    /**
     * Create account with Owner, default Currency (EUR) and secret key
     **/
    public Account(AccountHolderUser owner, String secretKey) {
        super(owner);
        setSecretKey(secretKey);
    }
    /**
     * Create account with Owner, specific Currency and secret key
     **/
    public Account(AccountHolderUser owner, Currency currency, String secretKey) {
        super(owner, currency);
        setSecretKey(secretKey);
    }

    /**
     * Create account with Owner, secondary Owner, default currency (EUR) and secret key
     **/
    public Account(AccountHolderUser owner, AccountHolderUser secondaryOwner, String secretKey) {
        super(owner, secondaryOwner);
        setSecretKey(secretKey);
    }

    public Account(String secretKey) {
        super();
        setSecretKey(secretKey);
    }


    /**
     * Create account with Owner, secondary Owner, specific currency and secret key
     **/
    public Account(AccountHolderUser owner, AccountHolderUser secondaryOwner, Currency currency, String secretKey) {
        super(owner, secondaryOwner, currency);
        setSecretKey(secretKey);
    }



    public Account() {
    }

    /**--------------------------Setter-----------------------------------------**/

    //Hago el Set secret key para luego implementar la logica de validacion del Secret Key
    private void setSecretKey (String secretKey)
    {
        this.secretKey = secretKey;
    };

}
