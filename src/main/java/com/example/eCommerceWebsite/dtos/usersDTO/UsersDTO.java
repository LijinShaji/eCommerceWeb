package com.example.eCommerceWebsite.dtos.usersDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UsersDTO {
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
}
