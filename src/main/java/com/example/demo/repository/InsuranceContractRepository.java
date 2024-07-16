package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InsuranceContractModel;

@Repository
public interface InsuranceContractRepository extends JpaRepository<InsuranceContractModel, Long> {
    
    List<InsuranceContractModel> findByEndDateBefore(Date endDate);
    
}
