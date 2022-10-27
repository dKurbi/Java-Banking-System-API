package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountStatus;
import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Money;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.repository.acoount.CheckingAccountRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    private final AccountHolderUserRepository accountHolderUserRepository;


    public CheckingAccount newCheckingAccount(CheckingAccountDto checkingAccountDto) {
        if (accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).isEmpty())
            return null; // Falta hacer la gestion de errores

        AccountHolderUser owner = accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).get();

        if (getOwnerAge(owner.getDateOfBirth()) > 24) {
            CheckingAccount checkingAccount = new CheckingAccount(checkingAccountDto.getSecretKey());
            checkingAccount.setOwner(owner);
            checkingAccount.setCreationDate(LocalDateTime.now());

            if (checkingAccountDto.getCurrency().isPresent()) {
                Currency Other = Currency.getInstance(checkingAccountDto.getCurrency().get());
                Money money = new Money(new BigDecimal(0), Other);
                checkingAccount.setBalance(money);
            } else {
                Currency Eur = Currency.getInstance("EUR");
                Money money = new Money(new BigDecimal(0), Eur);
                checkingAccount.setBalance(money);

            }

            checkingAccount.setStatus(AccountStatus.ACTIVE);
            if (checkingAccountDto.getSecondaryOwnerId().isPresent()) {
                Optional<AccountHolderUser> secondaryOwner = accountHolderUserRepository.findById(checkingAccountDto.getSecondaryOwnerId().get());
                if (secondaryOwner.isPresent()) {
                    checkingAccount.setSecondaryOwner(secondaryOwner.get());

                } else {
                    return null; // falta gestion de errores
                }
            }
            return checkingAccountRepository.save(checkingAccount);
        }

        // Falta Hacer Gestion de Errores, se tiene que crear una StudentCheckingAccount /////
        return null;

    }

    public static Currency stringToCurrency(String stringCurrency) {
        //Queda pendiente chequear la validez del string como currency
        return Currency.getInstance(stringCurrency);
    }

    public static Long getOwnerAge(LocalDate dateOfBirth) {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }
}