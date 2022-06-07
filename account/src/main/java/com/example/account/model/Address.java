package com.example.account.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Embeddable
public class Address {

    private String city;
    private String state;
    private String streetNumber;
    private String zip;
}
