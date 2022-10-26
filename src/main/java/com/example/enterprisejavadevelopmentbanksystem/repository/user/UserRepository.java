package com.example.enterprisejavadevelopmentbanksystem.repository.user;

import com.example.enterprisejavadevelopmentbanksystem.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
