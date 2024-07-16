package com.example.demo.constructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.demo.model.InsuranceContractModel;
import com.example.demo.repository.InsuranceContractRepository;

public class ContractMoniterTask implements Runnable {

    private InsuranceContractRepository repository;

    @Override
    public void run() {

        System.out.println("Thread running");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date oneDayBefore = calendar.getTime();

        List<InsuranceContractModel> contracts = repository.findByEndDateBefore(oneDayBefore);

        for (InsuranceContractModel contract : contracts) {
            System.out.println("Contract ended: " + contract);
            contract.setStatus("expired");
            repository.save(contract);
        }
    }
}
