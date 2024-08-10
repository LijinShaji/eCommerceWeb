package com.example.eCommerceWebsite.dtos.authDTO;

import com.example.eCommerceWebsite.models.userModel.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
    private Role role;
}