package com.transaction.api.config;

import com.transaction.api.entity.UserEntity;
import com.transaction.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) {

        if(repository.count() == 0) {

            repository.save(
                    UserEntity.builder()
                            .username("admin")
                            .password(
                                    encoder.encode(
                                            "admin123"
                                    )
                            )
                            .build()
            );
        }
    }
}