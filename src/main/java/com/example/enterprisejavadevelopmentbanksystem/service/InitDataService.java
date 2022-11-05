package com.example.enterprisejavadevelopmentbanksystem.service;

import com.example.enterprisejavadevelopmentbanksystem.enums.ERole;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AdminUser;
import com.example.enterprisejavadevelopmentbanksystem.model.user.Role;
import com.example.enterprisejavadevelopmentbanksystem.repository.account.AdminUserRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InitDataService {

    private final PasswordEncoder encoder;

    private final AdminUserRepository adminUserRepository;

    private final RoleRepository roleRepository;

    public void initData() {

            Role admin = new Role();
            admin.setName(ERole.ROLE_ADMIN);
            roleRepository.save(admin);

            Role accountHolder = new Role();
            accountHolder.setName(ERole.ROLE_ACCOUNT_HOLDER);
            roleRepository.save(accountHolder);

            Role thirdParty = new Role();
            thirdParty.setName(ERole.ROLE_THIRD_PARTY);
            roleRepository.save(thirdParty);


            AdminUser adminUser = new AdminUser("Admin", encoder.encode("admin"));
            Set<Role> roles = new HashSet<>();

            Role role = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(role);
            adminUser.setRoles(roles);
            adminUserRepository.save(adminUser);

    }

}


