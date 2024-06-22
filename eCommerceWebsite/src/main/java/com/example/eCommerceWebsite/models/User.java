package com.example.eCommerceWebsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String name;
    private String emailId;
    private String phoneNo;
    private  Address address;
}
