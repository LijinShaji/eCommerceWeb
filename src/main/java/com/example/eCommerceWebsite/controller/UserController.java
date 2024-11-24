package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import com.example.eCommerceWebsite.services.userservices.AddressService;
import com.example.eCommerceWebsite.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
 @Autowired
    UserService userService;
 @Autowired
 AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/profile")
    public UsersDTO getCurrentLoggedInUserDetails() {
        return userService.getUsersDTO();
    }
    @PutMapping("/profile")
    public ResponseDTO updateCurrentLoggedInUserDetails(@RequestBody UsersDTO usersDTO) {
        return userService.updateUserDetails(usersDTO);
    }

    @GetMapping("/address")
    public List<AddressDTO> getCurrentLoggedInAddressDetails() {
        return addressService.getCurrentUserAddresses();
    }

    @PostMapping("/address")
    public ResponseDTO addAddressUser(@RequestBody AddressDTO addressDTO) {
        return addressService.saveAddress(addressDTO);
    }

}
