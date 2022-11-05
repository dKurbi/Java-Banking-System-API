package com.example.enterprisejavadevelopmentbanksystem.service.user;

import com.example.enterprisejavadevelopmentbanksystem.enums.ERole;
import com.example.enterprisejavadevelopmentbanksystem.exception.NameAlreadyExistException;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.model.user.Address;
import com.example.enterprisejavadevelopmentbanksystem.model.user.Role;
import com.example.enterprisejavadevelopmentbanksystem.model.user.dto.AccountHolderUserAndAddressDto;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderUserRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AddressRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountHolderUserService {
    private final AccountHolderUserRepository accountHolderUserRepository;

    private final AddressRepository addressRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;


    public AccountHolderUser newAccountHolderUser(AccountHolderUserAndAddressDto accountHolderUserAndAddressDto) {
        if (accountHolderUserRepository.existsByNameLike(accountHolderUserAndAddressDto.getName())) {
            throw new NameAlreadyExistException(accountHolderUserAndAddressDto.getName());
        }
        Address address = new Address(accountHolderUserAndAddressDto.getPrimaryAddressStreet(),
                accountHolderUserAndAddressDto.getPrimaryAddressCity(),
                accountHolderUserAndAddressDto.getPrimaryAddressPostalCode(),
                accountHolderUserAndAddressDto.getPrimaryAddressCountry());
        addressRepository.save(address);

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_ACCOUNT_HOLDER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);


        AccountHolderUser newAccountHolderUser = new AccountHolderUser(accountHolderUserAndAddressDto.getName(),
                encoder.encode(accountHolderUserAndAddressDto.getPassword()),
                accountHolderUserAndAddressDto.getDateOfBirth(),
                address, roles);


        if (accountHolderUserAndAddressDto.getHasMailAddress()) {
            Address mailAddress = new Address(accountHolderUserAndAddressDto.getMailAddressStreet(),
                    accountHolderUserAndAddressDto.getMailAddressPostalCode(),
                    accountHolderUserAndAddressDto.getMailAddressCity(),
                    accountHolderUserAndAddressDto.getMailAddressCountry());
            addressRepository.save(mailAddress);
            newAccountHolderUser.setMailAddress(mailAddress);
        }

        return accountHolderUserRepository.save(newAccountHolderUser);


    }

    public List<AccountHolderUser> getAll() {
        return accountHolderUserRepository.findAll();
    }
}
