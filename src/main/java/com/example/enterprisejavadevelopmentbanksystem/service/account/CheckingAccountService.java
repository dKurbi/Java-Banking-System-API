package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.repository.acoount.CheckingAccountRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    private final AccountHolderRepository accountHolderRepository;


    public CheckingAccount newCheckingAccount(Long ownerId, Optional<Long> secondaryOwnerId, Optional<String> currency, String secretKey) {
        if (accountHolderRepository.findById(ownerId).isEmpty()) return null; // Falta hacer la gestion de errores

        AccountHolderUser owner = accountHolderRepository.findById(ownerId).get();

        if (getOwnerAge(owner.getDateOfBirth()) > 24) {

            /*---- Aca debe implementarse el error en caso de que el secondaryOwnerId este presente pero el Id no
             *  ----pertenezca  a ningun AccountHolderUser
             */
            if (secondaryOwnerId.isPresent() && accountHolderRepository.findById(secondaryOwnerId.get()).isEmpty()) {
                return null;
            }
            /*--------------------------------------------------------------**/


            Optional<AccountHolderUser> secondaryOwner = accountHolderRepository.findById(secondaryOwnerId.get());

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