package com.example.payment.model;

public interface PaymentMethods {
   Payment getPayment();
    String getPaymentUri();
    PaymentTypes getType();
}
