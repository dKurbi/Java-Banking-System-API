package com.example.enterprisejavadevelopmentbanksystem.model.user;

import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString

public class AccountHolderUser extends User{

    //-----------------Attributes
    private LocalDate dateOfBirth;


    @OneToOne
    @NotNull
    private Address primaryAddress;

    /*@OneToOne
    private Address mailAddress;
*/
    @OneToMany(mappedBy = "owner")
    private Set<BasicAccount> ownerAccountAssociation;

    @OneToMany(mappedBy = "secondaryOwner")
    private Set<BasicAccount> secondaryOwnerAccountAssociation;


    //------------------- Constructors

    public AccountHolderUser() {
    }

    public AccountHolderUser(String name, LocalDate dateOfBirth) {
        super(name);
        this.dateOfBirth = dateOfBirth;
    }
}
