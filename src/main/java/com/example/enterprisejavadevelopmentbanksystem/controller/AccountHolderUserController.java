package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.model.user.dto.AccountHolderUserAndAddressDto;
import com.example.enterprisejavadevelopmentbanksystem.service.user.AccountHolderUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class AccountHolderUserController {
    private final AccountHolderUserService accountHolderUserService;

    @PostMapping("/account_holders") //HAcer DTO
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolderUser newAccountHolderUser(@RequestBody AccountHolderUserAndAddressDto accountHolderUserAndAddressDto) {
        return accountHolderUserService.newAccountHolderUser(accountHolderUserAndAddressDto);

    }
    @GetMapping("/account_holders")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolderUser> getAll(){
        return accountHolderUserService.getAll();
    }

    }
