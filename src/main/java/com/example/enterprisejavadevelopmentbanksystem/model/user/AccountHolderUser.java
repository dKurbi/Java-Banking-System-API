package com.example.enterprisejavadevelopmentbanksystem.model.user;

import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString

public class AccountHolderUser extends User {

    //-----------------Attributes
    private LocalDate dateOfBirth;

    @ManyToOne
    @NotNull
    private Address primaryAddress;

    @ManyToOne
    private Address mailAddress;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<BasicAccount> ownerAccountAssociation;

    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private Set<BasicAccount> secondaryOwnerAccountAssociation;


    //------------------- Constructors


    public AccountHolderUser() {
    }

    public AccountHolderUser(String name, String password, LocalDate dateOfBirth) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
    }

    public AccountHolderUser(String name, String password, LocalDate dateOfBirth, Address primaryAddress, Set<Role> roles) {
        super(name, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.setRoles(roles);

    }
}
