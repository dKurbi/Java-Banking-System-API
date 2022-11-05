package com.example.enterprisejavadevelopmentbanksystem.repository.account;

import com.example.enterprisejavadevelopmentbanksystem.model.account.BasicAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicAccountRepository extends JpaRepository<BasicAccount, Long> {

    List<BasicAccount> findByOwner_UserID(Long userID);



}
