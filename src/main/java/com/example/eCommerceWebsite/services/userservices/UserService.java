package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
User getUser(String username);
User addNewUser(User user);
ResponseEntity<?> registerNewUser(UsersDTO user);
User loginUser(String username, String password);
User resetPassword(Long id, String newPassword);
User getUserById(Long id);
User updateUser(UsersDTO user);
User updateUserById(Long id, UsersDTO user);
}
