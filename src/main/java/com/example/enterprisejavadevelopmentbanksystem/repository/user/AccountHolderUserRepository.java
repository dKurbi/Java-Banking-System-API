package com.example.enterprisejavadevelopmentbanksystem.repository.user;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderUserRepository extends JpaRepository<AccountHolderUser, Long> {
    boolean existsByNameLike(String name);

}
