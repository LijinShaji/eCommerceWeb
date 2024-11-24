package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;

public interface UserService {
User getCurrentUser();
UsersDTO getUsersDTO();
 ResponseDTO updateUserDetails(UsersDTO usersDTO);
 //PutResponseDTO addAdressToUser(AddressDTO addressDTO);
}
