package com.example.demo.form;

import lombok.Data;

@Data
public class SignupForm {
    
    private String username;

    private String password;
    
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;
}
