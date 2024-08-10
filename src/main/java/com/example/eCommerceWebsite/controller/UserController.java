package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user= userService.loginUser(username, password);
        return getResponseEntity(user);
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UsersDTO user) {
        return userService.registerNewUser(user);
    }
    @GetMapping("/profile")
    public User getProfile(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/passwordReset")
    public User resetPassword(@RequestBody UsersDTO user, @RequestParam("id") Long id) {
        return userService.resetPassword(id,user.getNewPassword());
    }
    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestBody UsersDTO user, @RequestParam("id") Long id) {
        User user1=userService.updateUserById(id, user);
        return getResponseEntity(user1);
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
