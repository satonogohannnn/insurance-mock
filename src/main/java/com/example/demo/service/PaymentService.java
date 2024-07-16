package com.example.demo.service;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;

@Service
public class PaymentService implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println("支払いスレッド開始");

        boolean resultPayment = false;

        try {
            Thread.sleep(30000);
            resultPayment = processPayment();
        } catch (InterruptedException e) {
            System.out.println("スレッド終了");
        }

        System.out.println("支払いスレッド終了");
        return resultPayment;
    }
    
    public boolean processPayment() {

        return true;
    }
}
