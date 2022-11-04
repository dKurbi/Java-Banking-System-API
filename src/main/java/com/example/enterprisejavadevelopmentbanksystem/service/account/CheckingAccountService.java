package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountStatus;
import com.example.enterprisejavadevelopmentbanksystem.exception.AccountHolderIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.exception.SecondaryOwnerIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Money;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.CheckingAccountRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    private final AccountHolderUserRepository accountHolderUserRepository;

    private final StudentCheckingAccountService studentCheckingAccountService;
    private final PasswordEncoder encoder;


    public Account newCheckingAccount(CheckingAccountDto checkingAccountDto) {
        if (accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).isEmpty())
            throw new AccountHolderIdNotFoundException(checkingAccountDto.getOwnerId()); // Falta hacer la gestion de errores
        AccountHolderUser owner = accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).get();

        if (getOwnerAge(owner.getDateOfBirth()) > 24) {
            CheckingAccount checkingAccount = new CheckingAccount(encoder.encode(checkingAccountDto.getSecretKey()));
            checkingAccount.setOwner(owner);
            checkingAccount.setCreationDate(LocalDateTime.now());

            if (checkingAccountDto.getCurrency().isPresent()) {
                Currency Other = stringToCurrency(checkingAccountDto.getCurrency().get());
                Money money = new Money(new BigDecimal(0), Other);
                checkingAccount.setBalance(money);
            } else {
                Currency Eur = stringToCurrency("EUR");
                Money money = new Money(new BigDecimal(0), Eur);
                checkingAccount.setBalance(money);

            }

            checkingAccount.setStatus(AccountStatus.ACTIVE);
            if (checkingAccountDto.getSecondaryOwnerId().isPresent()) {
                Optional<AccountHolderUser> secondaryOwner = accountHolderUserRepository.findById(checkingAccountDto.getSecondaryOwnerId().get());
                if (secondaryOwner.isPresent()) {
                    checkingAccount.setSecondaryOwner(secondaryOwner.get());

                } else {
                    throw new SecondaryOwnerIdNotFoundException(checkingAccountDto.getSecondaryOwnerId().get());
                }
            }
            return checkingAccountRepository.save(checkingAccount);
        }

        return studentCheckingAccountService.newStudentCheckingAccount(checkingAccountDto);

    }

    public static Currency stringToCurrency(String stringCurrency) {
        //Queda pendiente chequear la validez del string como currency
        return Currency.getInstance(stringCurrency);
    }

    public static Long getOwnerAge(LocalDate dateOfBirth) {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public List<CheckingAccount> getAll() {
        return checkingAccountRepository.findAll();
    }
}