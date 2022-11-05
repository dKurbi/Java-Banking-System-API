package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountStatus;
import com.example.enterprisejavadevelopmentbanksystem.exception.AccountHolderIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.exception.OlderThan24Exception;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Money;
import com.example.enterprisejavadevelopmentbanksystem.model.account.StudentCheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.StudentCheckingAccountRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

import static com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService.getOwnerAge;
import static com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService.stringToCurrency;

@Service
@RequiredArgsConstructor
public class StudentCheckingAccountService {

    private final AccountHolderUserRepository accountHolderUserRepository;

    private final StudentCheckingAccountRepository studentCheckingAccountRepository;

    private final PasswordEncoder encoder;


    public Account newStudentCheckingAccount(CheckingAccountDto checkingAccountDto) {
        if (accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).isEmpty())
            throw new AccountHolderIdNotFoundException(checkingAccountDto.getOwnerId());

        AccountHolderUser owner = accountHolderUserRepository.findById(checkingAccountDto.getOwnerId()).get();
        if (getOwnerAge(owner.getDateOfBirth()) > 24) {
            throw new OlderThan24Exception(getOwnerAge(owner.getDateOfBirth()), owner.getUserID());
        }
        StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(encoder.encode(checkingAccountDto.getSecretKey()));
        studentCheckingAccount.setOwner(owner);
        studentCheckingAccount.setCreationDate(LocalDateTime.now());

        if (checkingAccountDto.getCurrency().isPresent()) {
            Currency Other = stringToCurrency(checkingAccountDto.getCurrency().get());
            Money money = new Money(new BigDecimal(0), Other);
            studentCheckingAccount.setBalance(money);
        } else {
            Currency Eur = stringToCurrency("EUR");
            Money money = new Money(new BigDecimal(0), Eur);
            studentCheckingAccount.setBalance(money);

        }

        studentCheckingAccount.setStatus(AccountStatus.ACTIVE);
        if (checkingAccountDto.getSecondaryOwnerId().isPresent()) {
            Optional<AccountHolderUser> secondaryOwner = accountHolderUserRepository.findById(checkingAccountDto.getSecondaryOwnerId().get());
            if (secondaryOwner.isPresent()) {
                studentCheckingAccount.setSecondaryOwner(secondaryOwner.get());

            } else {
                return null; // falta gestion de errores
            }
        }
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }

    public List<StudentCheckingAccount> getAll() {
        return studentCheckingAccountRepository.findAll();
    }
}
