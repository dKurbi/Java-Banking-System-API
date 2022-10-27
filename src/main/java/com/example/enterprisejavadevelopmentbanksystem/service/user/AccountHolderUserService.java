package com.example.enterprisejavadevelopmentbanksystem.service.user;

import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.model.user.Address;
import com.example.enterprisejavadevelopmentbanksystem.model.user.dto.AccountHolderUserAndAddressDto;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AccountHolderUserRepository;
import com.example.enterprisejavadevelopmentbanksystem.repository.user.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountHolderUserService {
    private final AccountHolderUserRepository accountHolderUserRepository;

    private final AddressRepository addressRepository;


    public AccountHolderUser newAccountHolderUser(AccountHolderUserAndAddressDto accountHolderUserAndAddressDto) {
        Address address = new Address(accountHolderUserAndAddressDto.getPrimaryAddressStreet(),
                accountHolderUserAndAddressDto.getPrimaryAddressCity(),
                accountHolderUserAndAddressDto.getPrimaryAddressPostalCode(),
                accountHolderUserAndAddressDto.getPrimaryAddressCountry());
        addressRepository.save(address);
        AccountHolderUser newAccountHolderUser = new AccountHolderUser(accountHolderUserAndAddressDto.getName(),
                accountHolderUserAndAddressDto.getPassword(),
                accountHolderUserAndAddressDto.getDateOfBirth(),
                address);


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
