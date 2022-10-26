package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checking_account")
public class CheckingAccountController {


    private final CheckingAccountService checkingAccountService;


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount newCheckingAccount(@RequestParam("owner_id") Long ownerId,
                                              @RequestParam("secondary_owner_id") Optional<Long> secondaryOwnerId,
                                              @RequestParam("currency") Optional<String> currency,
                                              @RequestParam("secret_key") String secretKey) {

        return checkingAccountService.newCheckingAccount(ownerId, secondaryOwnerId, currency, secretKey);

    }
}
