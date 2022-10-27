package com.example.enterprisejavadevelopmentbanksystem.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class AdminUser extends User {


    //-----------------------Constructors
    public AdminUser() {
    }

    public AdminUser(String name, String password) {
        super(name, password);
    }
}
