package com.example.demo.controller;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.SignupForm;
import com.example.demo.service.SignupService;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlConst.SIGNUP)
public class SignupController {
    
    @Autowired
    private SignupService service;

    @GetMapping
    public String view (Model model) {
        return "InsuranceList";
    }

    @PostMapping
    public void signup(Model model, SignupForm form) {
        service.resistUser(form);
    }
}
