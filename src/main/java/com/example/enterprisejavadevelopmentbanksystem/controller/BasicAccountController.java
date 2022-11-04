package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.BalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.GetBalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.service.account.BasicAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basic_accounts")
public class BasicAccountController {

    private final BasicAccountService basicAccountService;


    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<BasicAccount> getBy(@RequestParam("id") Optional<Long> id,

                                    @RequestParam("owner_id") Optional<Long> ownerId) {

        return basicAccountService.getBy(id, ownerId);
    }

    @GetMapping("/balance")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ACCOUNT_HOLDER')")
    public BalanceDto getBalance(@RequestBody GetBalanceDto getBalanceDto) {
        return basicAccountService.getBalance(getBalanceDto);

    }
}