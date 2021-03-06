package com.example.account.config;

import com.example.account.model.PaymentType;
import com.example.account.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class Init {
    private final PaymentTypeRepository paymentTypeRepository;

    @Autowired
    public Init(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @PostConstruct
    public void createTestPaymentTypes() {
        createPaymentTypes();
    }

    @Transactional
    public void createPaymentTypes() {
        PaymentType paymentTypeOne = new PaymentType();
        paymentTypeOne.setPaymentName("paypal");
        PaymentType paymentTypeTwo = new PaymentType();
        paymentTypeTwo.setPaymentName("credit card");
        PaymentType paymentTypeThree = new PaymentType();
        paymentTypeThree.setPaymentName("debit card");
        System.out.println("First time");
        paymentTypeRepository.save(paymentTypeOne);
        paymentTypeRepository.save(paymentTypeTwo);
        paymentTypeRepository.save(paymentTypeThree);
    }
}
