package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountType;
import com.example.enterprisejavadevelopmentbanksystem.exception.BasicAccountIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.exception.PasswordMismatchException;
import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.BalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.GetBalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder encoder;

    public BalanceDto getBalance(GetBalanceDto getBalanceDto) {
        Optional<Account> account = accountRepository.findById(getBalanceDto.getAccountId());
        if (account.isEmpty()) {
            throw new BasicAccountIdNotFoundException(getBalanceDto.getAccountId());
        }
        if (!encoder.matches(getBalanceDto.getSecretKey(),account.get().getSecretKey())) {
            throw new PasswordMismatchException();
        }
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.setAccountId(account.get().getAccountID());
        balanceDto.setBalance(account.get().getBalance());
        balanceDto.setCreationDate(account.get().getCreationDate());


        switch (account.get().getClass().getName()) {
            case "com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount" ->
                    balanceDto.setAccountType(AccountType.CHECKING_ACCOUNT);
            case "com.example.enterprisejavadevelopmentbanksystem.model.account.StudentCheckingAccount" ->
                    balanceDto.setAccountType(AccountType.STUDENT_CHECKING_ACCOUNT);
            case "com.example.enterprisejavadevelopmentbanksystem.model.account.SavingAccount" ->
                    balanceDto.setAccountType(AccountType.SAVING_ACCOUNT);
            case "com.example.enterprisejavadevelopmentbanksystem.model.account.CreditCard" ->
                    balanceDto.setAccountType(AccountType.CREDIT_CARD);


        }
        return balanceDto;

    }
}
