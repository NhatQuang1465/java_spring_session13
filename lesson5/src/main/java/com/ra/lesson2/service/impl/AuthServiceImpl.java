package com.ra.lesson2.service.impl;

import com.ra.lesson2.model.dto.RegisterRequest;
import com.ra.lesson2.model.entity.User;
import com.ra.lesson2.repository.UserRepository;
import com.ra.lesson2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(RegisterRequest dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists: " + dto.getUsername());
        }

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .fullName(dto.getFullName())
                .role("ROLE_USER")
                .enabled(true)
                .build();

        return userRepository.save(user);
    }
}
