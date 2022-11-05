package com.example.enterprisejavadevelopmentbanksystem.service.account;

import com.example.enterprisejavadevelopmentbanksystem.exception.BasicAccountIdNotFoundException;
import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.BasicAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasicAccountService {
    private final BasicAccountRepository basicAccountRepository;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
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


}


