package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.authDTO.AuthenticationRequest;
import com.example.eCommerceWebsite.dtos.authDTO.AuthenticationResponse;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.register(authenticationRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    }
    @PutMapping("/passwordReset")
    public User resetPassword(@RequestBody UsersDTO user, @RequestParam("id") Long id) {
        return null;
    }


}
