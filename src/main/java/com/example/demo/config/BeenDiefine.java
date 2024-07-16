package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.InsuranceContractModel;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Configuration
public class BeenDiefine {
    
    @Bean
    Mapper mapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }

    @Bean
    public InsuranceContractModel insuranceContractModel() {
        return new InsuranceContractModel();
    }
}
