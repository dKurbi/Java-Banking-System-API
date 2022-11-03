package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.model.user.dto.AccountHolderUserAndAddressDto;
import com.example.enterprisejavadevelopmentbanksystem.service.user.AccountHolderUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account_holders")
public class AccountHolderUserController {
    private final AccountHolderUserService accountHolderUserService;

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)

    public AccountHolderUser newAccountHolderUser(@RequestBody AccountHolderUserAndAddressDto accountHolderUserAndAddressDto) {
        return accountHolderUserService.newAccountHolderUser(accountHolderUserAndAddressDto);

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AccountHolderUser> getAll() {
        return accountHolderUserService.getAll();
    }
}

