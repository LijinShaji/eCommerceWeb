package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.services.userservices.UserService;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("api/v1/users")
public class UserController {
 @Autowired
    UserService userService;

    @GetMapping("/profile")
    public User getProfile(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestBody UsersDTO user,@RequestParam("id") Long id) {
        System.out.println("Hi");
        return ResponseEntity.ok(userService.updateUser(user));
    }

    private ResponseEntity<?> getResponseEntity(User user1) {
        if(user1 != null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(user1);
        }else{
            ErrorResponseBody error=new ErrorResponseBody();
            error.setStatus(404);
            error.setErrorMessage("Invalid username or password");
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(error);
        }
    }

}
