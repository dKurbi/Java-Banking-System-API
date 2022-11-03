package com.example.enterprisejavadevelopmentbanksystem.repository.account;

import com.example.enterprisejavadevelopmentbanksystem.model.account.StudentCheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingAccountRepository extends JpaRepository<StudentCheckingAccount, Long> {
}
