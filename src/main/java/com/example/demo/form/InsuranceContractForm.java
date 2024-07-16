package com.example.demo.form;

import java.util.Date;

import lombok.Data;

@Data
public class InsuranceContractForm {

    private Long userId;

    private Long planId;
    
    private String status;

    private Date endDate;

    private Date starDate;

}
