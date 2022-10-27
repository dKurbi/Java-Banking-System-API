package com.example.enterprisejavadevelopmentbanksystem.model.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
public class CheckingAccountDto {

    private Long ownerId;

    private Optional<Long> secondaryOwnerId;

    private Optional<String> currency;

    private String secretKey;

}
