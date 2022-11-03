package com.example.enterprisejavadevelopmentbanksystem.security.payload.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

}
