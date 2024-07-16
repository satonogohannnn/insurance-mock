package com.example.demo.serviceTest;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.form.SignupForm;
import com.example.demo.model.UserModel;
import com.example.demo.service.SignupService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SignupServiceTest {

    @Autowired
    private SignupService signupService;

    @Test
    public void testCreateUser() {
        SignupForm userForm = new SignupForm();
        userForm.setUsername("testuser4");
        userForm.setPassword("password");
        userForm.setEmail("testuser4@mail.com");
        userForm.setFirstName("test");
        userForm.setLastName("user");
        userForm.setPhoneNumber("08088888888");
        userForm.setAddress("宮城県仙台市青葉区");
        
        Optional<UserModel> createdUser = signupService.resistUser(userForm);

        assertThat(createdUser.isPresent()).isTrue();
        assertThat(createdUser.get().getId()).isNotNull();
        assertThat(createdUser.get().getUsername()).isEqualTo("testuser4");
        assertThat(createdUser.get().getEmail()).isEqualTo("testuser4@mail.com");

    }
}
