package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.enums.AccountType;
import com.example.enterprisejavadevelopmentbanksystem.exception.BasicAccountIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.exception.OwnerIdMismatchException;
import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.BalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.GetBalanceDto;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.BasicAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicAccountService {
    private final BasicAccountRepository basicAccountRepository;


    public List<BasicAccount> getBy(Optional<Long> id, Optional<Long> ownerId) {

        //----------------------find by id---------------------------------**/
        if (id.isPresent()) {
            Optional<BasicAccount> basicAccount = basicAccountRepository.findById(id.get());
            if (basicAccount.isPresent()) {
                List<BasicAccount> basicAccounts = new ArrayList<>();
                basicAccounts.add(basicAccount.get());
                return basicAccounts;
            } else {
                throw new BasicAccountIdNotFoundException(id.get());

            }
        }
        //----------------------find by ownerId---------------------------------**/
        if (ownerId.isPresent()) {

            return basicAccountRepository.findByOwner_UserID(ownerId.get());
        }
        return basicAccountRepository.findAll();
    }

    public BalanceDto getBalance(GetBalanceDto getBalanceDto) {
        Optional<BasicAccount> basicAccount = basicAccountRepository.findById(getBalanceDto.getAccountId());
        if (basicAccount.isEmpty()) {
            throw new BasicAccountIdNotFoundException(getBalanceDto.getAccountId());
        }
        if (!basicAccount.get().getOwner().getUserID().equals(getBalanceDto.getOwnerId()) ) {
            throw new OwnerIdMismatchException(getBalanceDto.getOwnerId());
        }
        BalanceDto balanceDto = new BalanceDto();
        balanceDto.setAccountId(basicAccount.get().getAccountID());
        balanceDto.setBalance(basicAccount.get().getBalance());
        balanceDto.setCreationDate(basicAccount.get().getCreationDate());


        switch (basicAccount.get().getClass().getName()) {
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


