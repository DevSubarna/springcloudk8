package com.example.payment.controller;

import com.example.payment.DTO.BankAccountRequest;
import com.example.payment.DTO.CreditCardRequest;
import com.example.payment.DTO.PaypalPaymentRequest;
import com.example.payment.model.*;
import com.example.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private String paypalAddress;
    private String ccAddress;
    private String bbAddress;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/paypal")
    public PaymentStatus processPaypal(@RequestBody PaypalPaymentRequest paymentRequest) {
        log.info("making payment for " + paymentRequest);
        PayPalPayment payment = new PayPalPayment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setPaypalId(paymentRequest.getPaypalId());
        payment.setBalance(paymentRequest.getBalance());
        PayPalPaymentMethod paymentMethod = new PayPalPaymentMethod(paypalAddress, payment);
        return paymentService.makePayment(paymentMethod, paymentRequest.getOrderId());
    }




    @PostMapping("/creditcard")
    public  PaymentStatus processCreditCard(@RequestBody CreditCardRequest creditCardRequest){
        log.info("making payment for " + creditCardRequest);

        CreditCardPayment payment = new CreditCardPayment();
        payment.setUserId(creditCardRequest.getUserId());
        payment.setCreditCardNumber(creditCardRequest.getCreditCardNumber());
        payment.setBalance(creditCardRequest.getBalance());
        CreditCardPaymentMethod paymentMethod = new CreditCardPaymentMethod(ccAddress, payment);
        return paymentService.makePayment(paymentMethod, creditCardRequest.getOrderId());

    }

    @PostMapping("/bankaccount")
    public  PaymentStatus processBankAccount(@RequestBody BankAccountRequest bankAccountRequest){
        log.info("making payment for " + bankAccountRequest);

        BankAccountPayment payment = new BankAccountPayment();
        payment.setAccountId(bankAccountRequest.getBankId());
        payment.setUserId(bankAccountRequest.getUserId());
        payment.setBalance(bankAccountRequest.getBalance());
        BankAccountPaymentMethod  paymentMethod = new BankAccountPaymentMethod(bbAddress, payment);
        return paymentService.makePayment(paymentMethod, bankAccountRequest.getOrderId());

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.findPayment(id), HttpStatus.OK);
    }

}