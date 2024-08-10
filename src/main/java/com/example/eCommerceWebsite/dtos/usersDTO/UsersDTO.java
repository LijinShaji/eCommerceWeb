package com.example.eCommerceWebsite.dtos.usersDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UsersDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String oldPassword;
    private String newPassword;
    private Role role;
    private Set<Address> address;
}
