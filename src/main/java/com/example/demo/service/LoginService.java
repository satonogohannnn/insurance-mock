package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    
    private final UserService userService;

    public Optional<UserModel> searchUserById(String email) {
        return userService.findByEmail(email);
    }
}
