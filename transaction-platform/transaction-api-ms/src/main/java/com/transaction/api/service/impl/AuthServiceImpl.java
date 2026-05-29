package com.transaction.api.service.impl;

import com.transaction.api.dto.request.LoginRequest;
import com.transaction.api.dto.response.LoginResponse;
import com.transaction.api.entity.UserEntity;
import com.transaction.api.repository.UserRepository;
import com.transaction.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    @Override
    public LoginResponse login(
            LoginRequest request) {

        UserEntity user =
                repository.findByUsername(
                        request.getUsername()
                ).orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        )
                );

        if(!encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid credentials"
            );
        }

        return LoginResponse.builder()
                .message("Login successful")
                .build();
    }
}
