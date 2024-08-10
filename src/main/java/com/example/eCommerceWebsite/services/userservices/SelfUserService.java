package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SelfUserService implements UserService {
    @Autowired
    AddressService addressService;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;



    public SelfUserService(UserRepository userRepository, AddressRepository addressRepository ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User addNewUser(User user) {

        User newUser = new User();
        user.setUser_id(user.getUser_id());
        user.setName(user.getName());
        user.setPassword(user.getPassword());

        newUser.setUserName(user.getUsername());
        newUser.setEmailId(user.getEmailId());
        newUser.setPhoneNo(user.getPhoneNo());
        User userNew= userRepository.save(newUser);
        if (user.getAddress() != null) {

            newUser.setAddress(saveAndUpdateAddresses(user.getAddress(),newUser));
        }
        return userNew;
    }

    @Override
    public ResponseEntity<?> registerNewUser(UsersDTO userData) {
        if(getUser(userData.getUserName())!=null){
            ErrorResponseBody errorResponseBody = new ErrorResponseBody();
            errorResponseBody.setStatus(404);
            errorResponseBody.setErrorMessage("User with same username already exists. Please login with this account or try again");
             return new ResponseEntity<>(errorResponseBody,HttpStatusCode.valueOf(404));
        }else{
            User user = getUser(userData);
            User newUser=userRepository.save(user);
          return new ResponseEntity<>(newUser,HttpStatusCode.valueOf(201));
        }
    }

    private static User getUser(UsersDTO userData) {
        User user=new User();
        user.setName(userData.getName());
        user.setPhoneNo(userData.getPhoneNumber());
        user.setUserName(userData.getUserName());
        user.setPassword(userData.getPassword());
        user.setEmailId(userData.getEmailId());
        return user;
    }


    @Override
    public User loginUser(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password);
    }

    @Override
    public User resetPassword(Long id, String newPassword) {
        User user=userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setPassword(newPassword);
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUserById(Long id, UsersDTO usersDTO) {
        User user=userRepository.findById(id).orElse(null);
       if(user!=null){
           user.setName(usersDTO.getName());
           user.setEmailId(usersDTO.getEmailId());
           user.setPhoneNo(usersDTO.getPhoneNumber());
           if(usersDTO.getAddress()!=null){
               user.setAddress(saveAndUpdateAddresses(usersDTO.getAddress(),user));
           }

           return userRepository.save(user);
       }
        return null;
    }
    public Set<Address> saveAndUpdateAddresses(Set<Address> addresses, User newUser) {
        Set<Address> newAddresses = new HashSet<>();
        for (Address address : addresses) {
            AddressService addressService=new SelfAddressService(addressRepository);
            address.setUser(newUser);
            Address newAddress= addressService.saveAddress(address);
            newAddresses.add(newAddress);
        }
        return newAddresses;
    }


}
