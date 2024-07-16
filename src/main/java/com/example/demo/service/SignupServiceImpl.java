package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.form.SignupForm;
import com.example.demo.model.UserModel;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

    private final UserService userService;

    private final Mapper mapper;

    @Override
    public Optional<UserModel> resistUser(SignupForm form) {
        Optional<UserModel> userExisted = userService.findByEmail(form.getEmail());
        if (userExisted.isPresent()) {
            return Optional.empty();
        }

        UserModel user = mapper.map(form, UserModel.class);

        return Optional.of(userService.createUser(user));
    }
}
