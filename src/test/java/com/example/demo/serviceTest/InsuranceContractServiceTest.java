package com.example.demo.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.form.InsuranceContractForm;
import com.example.demo.model.InsuranceContractModel;
import com.example.demo.service.InsuranceContractService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
public class InsuranceContractServiceTest {
    
    @Autowired
    private InsuranceContractService insuranceContractService;

    @Test
    public void createdContract(){
        InsuranceContractForm contractForm = new InsuranceContractForm();

        contractForm.setUserId((long) 1);
        contractForm.setPlanId((long) 2);

        Optional<InsuranceContractModel> insuranceContract = insuranceContractService.resistContract(contractForm);

        assertThat(insuranceContract.isPresent()).isTrue();
        assertThat(insuranceContract.get().getId()).isNotNull();
        assertThat(insuranceContract.get().getUserId()).isEqualTo((long) 1);
        assertThat(insuranceContract.get().getPlanId()).isEqualTo((long) 2);
        assertThat(insuranceContract.get().getStatus()).isEqualTo("active");
    }
}
