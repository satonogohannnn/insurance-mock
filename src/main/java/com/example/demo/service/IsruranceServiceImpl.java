package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InsuranceModel;
import com.example.demo.repository.InsuranceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IsruranceServiceImpl implements InsuranceService {
    
    @Autowired
    private final InsuranceRepository insuranceRepository;

    @Override
    public List<InsuranceModel> getAllInsurance() {
        return insuranceRepository.findAll();
    }
}
