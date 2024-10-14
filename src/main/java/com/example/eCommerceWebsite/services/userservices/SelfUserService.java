package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
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

    @Autowired
    AuthenticationService authenticationService;


    public SelfUserService(UserRepository userRepository, AddressRepository addressRepository ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }
    @Override
    public UsersDTO getUsersDTO(String username) {
        User user = getUser(username);
        UsersDTO usersDTO = new UsersDTO();
        if (user != null) {
            usersDTO.setUserName(user.getUsername());
            usersDTO.setEmailId(user.getEmailId());
            usersDTO.setRole(user.getRole());
        }
        return usersDTO;
    }


    private static User getUser(UsersDTO userData) {
        String name = userData.getFirstName() +
                " " +
                userData.getLastName();
        User user=new User();
        user.setName(name);
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
    public User updateUser(UsersDTO usersDTO) {
        String username= authenticationService.getCurrentUsername();
        User user=userRepository.findByUserName(username);
        return updateUser(usersDTO, user);
    }

    private User updateUser(UsersDTO usersDTO, User user) {
        if(user!=null){
            user.setName(usersDTO.getFirstName()+" "+usersDTO.getLastName());
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
