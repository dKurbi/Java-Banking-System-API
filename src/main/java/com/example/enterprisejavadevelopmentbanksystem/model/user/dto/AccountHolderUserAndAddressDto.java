package com.example.enterprisejavadevelopmentbanksystem.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AccountHolderUserAndAddressDto {


    private String name;

    private String password;

    private LocalDate dateOfBirth;

    private String primaryAddressStreet;

    private String primaryAddressCity;

    private String primaryAddressPostalCode;

    private String primaryAddressCountry;

    private Boolean hasMailAddress;

    private String mailAddressStreet;

    private String mailAddressCity;

    private String mailAddressPostalCode;

    private String mailAddressCountry;


}
