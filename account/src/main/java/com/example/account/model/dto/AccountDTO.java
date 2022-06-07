package com.example.account.model.dto;

import com.example.account.model.Address;
import com.example.account.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private Address shippingAddress;
    private Set<PaymentType> paymentTypes;
    private String preferredPaymentType;

}
