package com.example.enterprisejavadevelopmentbanksystem.model.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBalanceDto {

    private Long ownerId;

    private Long accountId;
}
