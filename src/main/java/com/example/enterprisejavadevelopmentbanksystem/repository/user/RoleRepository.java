package com.example.enterprisejavadevelopmentbanksystem.repository.user;

import java.util.Optional;

import com.example.enterprisejavadevelopmentbanksystem.enums.ERole;
import com.example.enterprisejavadevelopmentbanksystem.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
