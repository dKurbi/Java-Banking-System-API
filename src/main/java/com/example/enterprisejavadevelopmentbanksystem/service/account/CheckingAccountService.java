package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.repository.acoount.CheckingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;


    public CheckingAccount newCheckingAccount(AccountHolderUser owner, Optional<AccountHolderUser> secondaryOwner, Optional<String> currency, String secretKey) {

        if (secondaryOwner.isPresent() && currency.isPresent()) {

            CheckingAccount newCheckingAccount = new CheckingAccount(owner, secondaryOwner.get(), stringToCurrency(currency.get()), secretKey);
            return checkingAccountRepository.save(newCheckingAccount);

        } else if (secondaryOwner.isPresent()) {

            CheckingAccount newCheckingAccount = new CheckingAccount(owner, secondaryOwner.get(), secretKey);
            return checkingAccountRepository.save(newCheckingAccount);

        } else if (currency.isPresent()) {

            CheckingAccount newCheckingAccount = new CheckingAccount(owner, stringToCurrency(currency.get()), secretKey);
            return checkingAccountRepository.save(newCheckingAccount);
        }

        CheckingAccount newCheckingAccount = new CheckingAccount(owner, secretKey);
        return checkingAccountRepository.save(newCheckingAccount);
    }

    public Currency stringToCurrency(String stringCurrency) {
        //Queda pendiente chequear la validez del string como currency
        return Currency.getInstance(stringCurrency);
    }
}
