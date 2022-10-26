package com.example.enterprisejavadevelopmentbanksystem.service.user;

import com.example.enterprisejavadevelopmentbanksystem.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


}
