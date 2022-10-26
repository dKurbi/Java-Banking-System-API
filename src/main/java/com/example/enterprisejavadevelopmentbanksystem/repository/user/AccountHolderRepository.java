package com.example.enterprisejavadevelopmentbanksystem.repository.user;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolderUser, Long> {
}
