package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User getCurrentUser() {
        String username= authenticationService.getCurrentUsername();
        return userRepository.findByUserName(username);
    }
    @Override
    public UsersDTO getUsersDTO() {
        String username = authenticationService.getCurrentUsername();
        System.out.println(username);
        User user = userRepository.findByUserName(username);
        UsersDTO usersDTO = new UsersDTO();
        if (user != null) {
            usersDTO.setEmailId(user.getEmailId());
            usersDTO.setFirstName(user.getFirstname());
            usersDTO.setLastName(user.getLastname());
            usersDTO.setName(user.getName());
            usersDTO.setPhoneNumber(user.getPhoneNo());
        }
        return usersDTO;
    }

    @Override
    public ResponseDTO updateUserDetails(UsersDTO usersDTO) {
        ResponseDTO putResponseDTO = new ResponseDTO();
        String username = authenticationService.getCurrentUsername();
        User user = userRepository.findByUserName(username);
        if(user == null) {
            putResponseDTO.setCode(401);
            putResponseDTO.setMessage("User not found");
            return putResponseDTO;
        }
        user.setEmailId(usersDTO.getEmailId());
        user.setFirstname(usersDTO.getFirstName());
        user.setLastname(usersDTO.getLastName());
        user.setName(usersDTO.getFirstName()+" "+usersDTO.getLastName());
        user.setPhoneNo(usersDTO.getPhoneNumber());
        var a=userRepository.save(user);
        System.out.println(a);
        putResponseDTO.setCode(200);
        putResponseDTO.setMessage("User updated");
        return putResponseDTO;
    }

//    @Override
//    public PutResponseDTO addAdressToUser(AddressDTO addressDTO) {
//        String username = authenticationService.getCurrentUsername();
//        User user=userRepository.findByUserName(username);
//        return addressService.saveAddress(addressDTO,user);
//    }
}
