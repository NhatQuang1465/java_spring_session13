package com.ra.lesson2.service;

import com.ra.lesson2.model.dto.RegisterRequest;
import com.ra.lesson2.model.entity.User;

public interface AuthService {
    User register(RegisterRequest dto);
}
