package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.StudentCheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.service.account.StudentCheckingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student_checking_accounts")
public class StudentCheckingAccountController {
    private final StudentCheckingAccountService studentCheckingAccountService;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Account newCheckingAccount(@RequestBody CheckingAccountDto checkingAccountDto) {

        return studentCheckingAccountService.newStudentCheckingAccount(checkingAccountDto);

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCheckingAccount> getAll(){
        return studentCheckingAccountService.getAll();
    }


}

