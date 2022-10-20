package com.example.enterprisejavadevelopmentbanksystem.model.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class BasicAccount {


    //---------- Attributes
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long accountID;

    private LocalDateTime creationDate;

    //------------Constructors


    public BasicAccount(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BasicAccount() {
    }
}
