package com.example.enterprisejavadevelopmentbanksystem.repository.acoount;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
