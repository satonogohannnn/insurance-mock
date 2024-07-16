package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.constructor.ContractMoniterTask;
import com.example.demo.form.InsuranceContractForm;
import com.example.demo.model.InsuranceContractModel;
import com.example.demo.model.InsuranceModel;
import com.example.demo.repository.InsuranceContractRepository;
import com.example.demo.repository.InsuranceRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceContranctServiceImpl implements InsuranceContractService {
    
    @Autowired
    private final InsuranceContractRepository insuranceContractRepository;

    @Autowired
    private InsuranceRepository repository;

    @Autowired
    private Mapper mapper;

    @Scheduled(cron = "0 0 0 * * ?")    //  毎日深夜0時に実行
    public void checkContracts() {
        ContractMoniterTask task = new ContractMoniterTask();
        new Thread(task).start();
    }

    @Override
    public Optional<InsuranceContractModel> resistContract(InsuranceContractForm form) {
        LocalDate currentDate = LocalDate.now();
        Date starDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        form.setStarDate(starDate);
        form.setEndDate(reurnEndDate(currentDate, form));

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> futureResult = executor.submit(new PaymentService());
        try {
            boolean resultPayment = futureResult.get();
            if (resultPayment) {
                form.setStatus("active");
            } else {
                form.setStatus("Faild");
            }

        } catch (Exception e) {
            System.out.println(e);
            form.setStatus("Faild");
        }
        
        InsuranceContractModel contract = mapper.map(form, InsuranceContractModel.class);
        return Optional.of(insuranceContractRepository.save(contract));
    }

    private Date reurnEndDate(LocalDate currentDate, InsuranceContractForm form) {
        System.out.println(form.getPlanId());
        Optional<InsuranceModel> insuranceById = repository.findById(form.getPlanId());

        LocalDate endLocalDate;

        if (insuranceById.isPresent()) {
            endLocalDate = currentDate.plusDays(insuranceById.get().getDurationMonths());
        } else {
            endLocalDate = currentDate;
        }

        Date enDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return enDate;
    }
}
