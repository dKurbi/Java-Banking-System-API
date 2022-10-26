package com.example.enterprisejavadevelopmentbanksystem;

import com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestMethods {

    @Test
    @DisplayName("Test Method Get Owner Age")
    void testMethodGetOwnerAge() {
        int plus = LocalDate.now().getYear() - 2022;
        LocalDate dateOfBirth = LocalDate.of(1983, 3, 12);
        assertEquals(39 + plus, CheckingAccountService.getOwnerAge(dateOfBirth));

        LocalDate dateOfBirth1 = LocalDate.of(2014, 5, 21);
        assertEquals(8 + plus, CheckingAccountService.getOwnerAge(dateOfBirth1));

        LocalDate dateOfBirth2 = LocalDate.of(1933, 7, 30);
        assertEquals(89 + plus, CheckingAccountService.getOwnerAge(dateOfBirth2));
    }

}