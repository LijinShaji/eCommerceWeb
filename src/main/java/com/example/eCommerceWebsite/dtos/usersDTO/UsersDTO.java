package com.example.eCommerceWebsite.dtos.usersDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UsersDTO {
    private String userName;
    private String name;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String oldPassword;
    private String newPassword;
    private Role role;
//    private List<Address> address;
    private Set<Address> address;
}
