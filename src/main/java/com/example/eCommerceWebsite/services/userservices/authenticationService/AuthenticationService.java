package com.example.eCommerceWebsite.services.userservices.authenticationService;

import com.example.eCommerceWebsite.dtos.usersDTO.AuthenticationResponse;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;

public interface AuthenticationService {
public AuthenticationResponse register(UsersDTO userDto);
public AuthenticationResponse authenticate(String username,String password);
}
