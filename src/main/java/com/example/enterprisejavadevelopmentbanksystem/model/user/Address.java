package com.example.enterprisejavadevelopmentbanksystem.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

