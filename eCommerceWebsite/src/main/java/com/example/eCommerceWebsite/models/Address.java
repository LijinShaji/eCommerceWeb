package com.example.eCommerceWebsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String locality;
    private String district;
    private String state;
    private int pinCode;
}
