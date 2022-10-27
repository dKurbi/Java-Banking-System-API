package com.example.enterprisejavadevelopmentbanksystem.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    //-----------------------Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long userID;


    @NotNull
    private String name;

    @NotNull
    private String password;


    //-----------------------Constructors
    public User() {

    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
