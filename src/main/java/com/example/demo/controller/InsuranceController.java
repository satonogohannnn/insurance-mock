package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.InsuranceForm;
import com.example.demo.model.InsuranceModel;
import com.example.demo.service.InsuranceService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(UrlConst.PLAN)
public class InsuranceController {
    
    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public String view(Model model, InsuranceForm form) {

        List<InsuranceModel> insuranceList = insuranceService.getAllInsurance();


        return "insuranceList";
    }
}
