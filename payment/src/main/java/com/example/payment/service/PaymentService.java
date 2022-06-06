package com.example.payment.service;

import com.example.payment.model.OrderPayment;
import com.example.payment.model.PaymentMethods;
import com.example.payment.model.PaymentStatus;
import com.sun.istack.NotNull;

public interface PaymentService {
    PaymentStatus makePayment(PaymentMethods paymentMethods, @NotNull String orderid);

    OrderPayment findPayment(Long id);
}
