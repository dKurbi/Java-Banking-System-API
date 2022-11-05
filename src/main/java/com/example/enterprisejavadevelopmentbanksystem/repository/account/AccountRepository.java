package com.example.enterprisejavadevelopmentbanksystem.repository.account;

import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}

