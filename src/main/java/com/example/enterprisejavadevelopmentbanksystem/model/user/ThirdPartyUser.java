package com.example.enterprisejavadevelopmentbanksystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ToString
public class ThirdPartyUser extends User {


    //-------------------- Attributes
    @Column(nullable = false)
    private String hashKey;

    public ThirdPartyUser(String name, String hashKey) {
        super(name);
        this.hashKey = hashKey;
    }


    //-----------------------Constructors
    public ThirdPartyUser() {

    }
}
