package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.service.InitDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/init_data")
public class InitDataController {

    private final InitDataService initDataService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void initData(){
         initDataService.initData();
    }
}
