package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.usersDTO.usersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
User getUser(String username);
User addNewUser(User user);
ResponseEntity<?> registerNewUser(usersDTO user);
User loginUser(String username, String password);
User resetPassword(Long id, String newPassword);
User getUserById(Long id);
User updateUserById(Long id, usersDTO user);
}
