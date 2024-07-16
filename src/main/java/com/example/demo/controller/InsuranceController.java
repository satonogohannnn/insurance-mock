package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.InsuranceForm;
import com.example.demo.model.InsuranceModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.InsuranceService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(UrlConst.PLAN)
public class InsuranceController {
    
    @Autowired
    private InsuranceService insuranceService;

    
    @GetMapping
    public String view(Model model, InsuranceForm form, HttpSession session) {
        UserModel loggedInUser = (UserModel) session.getAttribute("loggedInUser");
        System.out.println(loggedInUser);
        
        List<InsuranceModel> insuranceList = insuranceService.getAllInsurance();

        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("insurances", insuranceList);

        return "insuranceList";
    }
}
