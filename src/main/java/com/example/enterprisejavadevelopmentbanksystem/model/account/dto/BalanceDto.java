package com.example.enterprisejavadevelopmentbanksystem.model.account.dto;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountType;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Money;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BalanceDto {

    private Long accountId;

    private LocalDateTime creationDate;

    private Money balance;

    private AccountType accountType;
}
