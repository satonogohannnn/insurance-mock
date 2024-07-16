package com.example.demo.service;

import java.util.Optional;

import com.example.demo.form.InsuranceContractForm;
import com.example.demo.model.InsuranceContractModel;

public interface InsuranceContractService  {

    Optional<InsuranceContractModel> resistContract(InsuranceContractForm form);
    
}
