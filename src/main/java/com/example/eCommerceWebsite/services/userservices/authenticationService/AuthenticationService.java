package com.example.eCommerceWebsite.services.userservices.authenticationService;

import com.example.eCommerceWebsite.dtos.authDTO.AuthenticationRequest;
import com.example.eCommerceWebsite.dtos.authDTO.AuthenticationResponse;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;

public interface AuthenticationService {
public AuthenticationResponse register(AuthenticationRequest authenticationRequest);
public AuthenticationResponse authenticate(String username,String password);
public String getCurrentUsername();
}
