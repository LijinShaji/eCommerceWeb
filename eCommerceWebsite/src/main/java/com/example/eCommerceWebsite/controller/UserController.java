package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.models.Address;
import com.example.eCommerceWebsite.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/getUsers")
    public User createUser(){
        Address address=new Address("street1","locality1","Bangalore urban","Karnataka",562162);
        return new User(10L,"lijinshaji16","Lijin","lijinshaji@gmail.com","7406409868",address);
    }


}