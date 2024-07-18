package com.example.eCommerceWebsite.services.globalServices;

import com.example.eCommerceWebsite.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Service
public class CommonFunction {
    @Autowired
    UserService userService;

public String getCurrentDateTime(){
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return currentDateTime.format(formatter);
    }
//    public User initializeSysFields(User user){
//        String currentDateTime = getCurrentDateTime();
//        user.setCreatedAt(currentDateTime);
//        user.setUpdatedAt(currentDateTime);
//        user.setCreatedBy("admin");
//        user.setUpdatedBy("admin");
//    return user;
//    }
//
//    public User updateSysFields(User user){
//    String currentDateTime = getCurrentDateTime();
//    user.setUpdatedAt(currentDateTime);
//    user.setUpdatedBy(user.getUserName());
//    return user;
//    }
}
