package com.ra.lesson2.controller;

import com.ra.lesson2.model.dto.RegisterRequest;
import com.ra.lesson2.model.entity.User;
import com.ra.lesson2.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest dto) {
        User registeredUser = authService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
