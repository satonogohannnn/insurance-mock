package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.InsuranceContractForm;
import com.example.demo.model.InsuranceModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.service.InsuranceContractService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(UrlConst.CONTRACT)
public class ContractController {

    @Autowired
    private InsuranceContractService insuranceContractService;

    @Autowired
    private InsuranceRepository insuranceRepository;
    
    @GetMapping
    public String view(@RequestParam String param, Model model, InsuranceContractForm form, HttpSession session) {
        long planId = Integer.parseInt(param);
        UserModel loggedInUser = (UserModel) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        Optional<InsuranceModel> planOpt = insuranceRepository.findById(planId);

        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("insurance", planOpt.get());
        model.addAttribute("param", planId);
        
        return "insuranceContract";
    }

    @PostMapping
    public String createContract(@RequestParam String param, Model model, InsuranceContractForm form, HttpSession session) {
        UserModel loggedInUser = (UserModel) session.getAttribute("loggedInUser");

        long planId = Integer.parseInt(param);
        form.setUserId(loggedInUser.getId());
        form.setPlanId(planId);

        insuranceContractService.resistContract(form);

        return "contractSuccess";
    }
    
}
