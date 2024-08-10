package com.example.eCommerceWebsite.auth;

import com.example.eCommerceWebsite.dtos.usersDTO.AuthenticationRequest;
import com.example.eCommerceWebsite.dtos.usersDTO.AuthenticationResponse;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
import com.google.api.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok(authenticationService.register(usersDTO));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    }
}
