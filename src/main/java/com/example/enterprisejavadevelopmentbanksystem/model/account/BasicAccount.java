package com.example.enterprisejavadevelopmentbanksystem.model.account;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class BasicAccount {


    /*
     * -------------------------- Attributes---------------------------
     **/
    private static final Currency USD = Currency.getInstance("USD");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long accountID;

    private LocalDateTime creationDate;

    @Embedded

    private Money balance;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private AccountHolderUser owner;

    @ManyToOne
    @JsonIgnore
    private AccountHolderUser secondaryOwner;


    /*-------------------------Constructors --------------------**/
    /*
     * Create account with Owner, Secondary Owner and specific Currency
     **/

    public BasicAccount(AccountHolderUser owner, AccountHolderUser secondaryOwner, Currency currency) {
        this.creationDate = LocalDateTime.now();
        this.owner = owner;
        this.secondaryOwner = secondaryOwner;
        this.balance = new Money(new BigDecimal(0), currency);
    }

    /*
     * Create account with Owner and Secondary Owner with default Currency (EU)
     **/

    public BasicAccount(AccountHolderUser owner, AccountHolderUser secondaryOwner) {
        Currency EUR = Currency.getInstance("EUR");
        this.creationDate = LocalDateTime.now();
        this.owner = owner;
        this.secondaryOwner = secondaryOwner;
        this.balance = new Money(new BigDecimal(0),EUR);

    }

    /*
     * Create account with Owner and specific Currency
     **/
    public BasicAccount(AccountHolderUser owner, Currency currency) {
        this.creationDate = LocalDateTime.now();
        this.owner = owner;
        this.balance = new Money(new BigDecimal(0), currency);
    }

    /*
     * Create account with Owner with default Currency (EU)
     **/
    public BasicAccount(AccountHolderUser owner) {
        Currency EUR = Currency.getInstance("EUR");
        this.creationDate = LocalDateTime.now();
        this.owner = owner;
        this.balance = new Money(new BigDecimal(0), EUR);
    }
    public BasicAccount() {
    }
}
