package com.example.enterprisejavadevelopmentbanksystem.model.user;

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


    public ThirdPartyUser(String name, String hashKey) {
        super(name, hashKey);

    }


    //-----------------------Constructors
    public ThirdPartyUser() {

    }
}
