package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.PutResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
User getCurrentUser();
UsersDTO getUsersDTO();
 PutResponseDTO updateUserDetails(UsersDTO usersDTO);
 //PutResponseDTO addAdressToUser(AddressDTO addressDTO);
}
