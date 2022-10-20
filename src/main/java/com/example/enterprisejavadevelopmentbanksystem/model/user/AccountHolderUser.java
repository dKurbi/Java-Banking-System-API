package com.example.enterprisejavadevelopmentbanksystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString

public class AccountHolderUser extends User{

    //-----------------Attributes
    private LocalDate dateOfBirth;

    @OneToOne
    @Column(nullable = false)
    private Address primaryAddress;

    @OneToOne
    private Address mailAddress;


    //------------------- Constructors

    public AccountHolderUser() {
    }

    public AccountHolderUser(String name, LocalDate dateOfBirth) {
        super(name);
        this.dateOfBirth = dateOfBirth;
    }
}
