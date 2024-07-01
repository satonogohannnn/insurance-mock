package com.example.demo.service;

import java.util.Optional;

import com.example.demo.form.SignupForm;
import com.example.demo.model.UserModel;

public interface SignupService {

    public Optional<UserModel> resistUser(SignupForm form);
}