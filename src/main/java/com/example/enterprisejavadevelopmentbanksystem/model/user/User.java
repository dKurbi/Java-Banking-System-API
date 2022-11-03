package com.example.enterprisejavadevelopmentbanksystem.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    //-----------------------Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long userID;


    @NotNull
    private String name;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    //-----------------------Constructors
    public User() {

    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
