package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checking_accounts")
public class CheckingAccountController {


    private final CheckingAccountService checkingAccountService;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount newCheckingAccount(@RequestBody CheckingAccountDto checkingAccountDto) {

        return checkingAccountService.newCheckingAccount(checkingAccountDto);

    }
}
