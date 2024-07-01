package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.LoginForm;
import com.example.demo.model.UserModel;
import com.example.demo.service.LoginService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(UrlConst.LOGIN)
public class LoginController {
    
    @Autowired
    private LoginService service;

    @GetMapping
    public String view(Model model, LoginForm form) {
        return "login";
    }

    @PostMapping
    public String login(Model model, LoginForm form) {
        Optional<UserModel> user = service.searchUserById(form.getEmail());
        boolean isCorrecteUser = user.isPresent() && form.getPassword() == user.get().getPassword();

        if (isCorrecteUser) {
            return "redirect:/insuranceList";
        }

        return "login";
    }
}
