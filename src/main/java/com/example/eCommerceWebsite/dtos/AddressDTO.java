package com.example.eCommerceWebsite.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String locality;
    private String district;
    private String state;
    private int pinCode;
}
