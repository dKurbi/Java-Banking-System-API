package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.BalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.GetBalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")

public class AccountController {

private final AccountService accountService;

    @GetMapping("/balance")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ACCOUNT_HOLDER')")
    public BalanceDto getBalance(@RequestBody GetBalanceDto getBalanceDto) {
        return accountService.getBalance(getBalanceDto);

    }
}
