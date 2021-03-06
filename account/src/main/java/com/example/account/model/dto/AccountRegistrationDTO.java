package com.example.account.model.dto;

import com.example.account.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRegistrationDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String preferredPaymentType;
    private Address shippingAddress;
}
