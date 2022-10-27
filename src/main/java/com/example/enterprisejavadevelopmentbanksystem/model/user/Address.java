package com.example.enterprisejavadevelopmentbanksystem.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //-------------------Attributes

    private Long addressID;

    private String street;

    private String city;

    private String postalCode;

    private String country;

    @OneToMany (mappedBy = "primaryAddress")
    @JsonIgnore
    private List<AccountHolderUser> user;

    @OneToMany (mappedBy = "mailAddress")
    @JsonIgnore
    private List<AccountHolderUser> userMailAddress;



    //-----------------------Constructors
    public Address() {
    }

    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


}

