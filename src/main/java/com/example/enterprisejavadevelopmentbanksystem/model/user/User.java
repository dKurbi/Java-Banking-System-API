package com.example.enterprisejavadevelopmentbanksystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//-----------------------Attributes
    private Long userID;

    @Column(nullable = false)
    private String name;

//-----------------------Constructors
    public User() {

    }

    public User(String name) {
        this.name = name;
    }
}