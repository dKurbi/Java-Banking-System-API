package com.example.enterprisejavadevelopmentbanksystem.repository.account;


import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
