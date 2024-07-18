package com.example.eCommerceWebsite.dtos;
import com.example.eCommerceWebsite.models.userModel.Address;
import lombok.Data;

import java.util.Set;

@Data
public class usersDTO {
    private String userName;
    private String name;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String oldPassword;
    private String newPassword;
//    private List<Address> address;
    private Set<Address> address;
}
