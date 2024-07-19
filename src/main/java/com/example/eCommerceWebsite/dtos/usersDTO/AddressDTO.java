package com.example.eCommerceWebsite.dtos.usersDTO;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String locality;
    private String district;
    private String state;
    private int pinCode;
}
