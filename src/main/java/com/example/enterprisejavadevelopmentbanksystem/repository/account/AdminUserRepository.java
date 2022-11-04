package com.example.enterprisejavadevelopmentbanksystem.repository.account;



import com.example.enterprisejavadevelopmentbanksystem.model.user.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

}
