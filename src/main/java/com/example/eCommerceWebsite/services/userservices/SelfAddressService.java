package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import com.example.eCommerceWebsite.services.userservices.authenticationService.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelfAddressService implements AddressService {
    private final AddressRepository addressRepository;
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public SelfAddressService(AddressRepository addressRepository, UserRepository userRepository, AuthenticationService authenticationService ) {
        this.addressRepository = addressRepository;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseDTO saveAddress(AddressDTO address) {
        String username=authenticationService.getCurrentUsername();
        User user=userRepository.findByUserName(username);

        ResponseDTO putResponseDTO = new ResponseDTO();
        if(user==null){
            putResponseDTO.setMessage("User not found");
            putResponseDTO.setCode(401);
            return putResponseDTO;
        }
        Address newaddress= new Address();
        newaddress.setPinCode(address.getPinCode());
        newaddress.setState(address.getState());
        newaddress.setLocality(address.getLocality());
        newaddress.setDistrict(address.getDistrict());
        newaddress.setStreet(address.getStreet());
        newaddress.setUser(user);
        addressRepository.save(newaddress);
        putResponseDTO.setMessage("Success");
        putResponseDTO.setCode(200);
        return putResponseDTO;
    }

    @Override
    public List<AddressDTO> getCurrentUserAddresses() {
        String username=authenticationService.getCurrentUsername();
        User user=userRepository.findByUserName(username);
        List<Address> addresses= addressRepository.findAllByUser(user);
        List<AddressDTO> addressDTOS=new ArrayList<>();
        addresses.forEach(address -> {
            AddressDTO addressDTO=new AddressDTO();
            addressDTO.setPinCode(address.getPinCode());
            addressDTO.setState(address.getState());
            addressDTO.setLocality(address.getLocality());
            addressDTO.setDistrict(address.getDistrict());
            addressDTO.setStreet(address.getStreet());
            addressDTOS.add(addressDTO);
        });
        return addressDTOS;
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id);
    }


    @Override
    public Address updateAddress(AddressDTO addressDTO, long id) {
        Address address=getAddressById(id);
        address.setPinCode(addressDTO.getPinCode());
        address.setState(addressDTO.getState());
        address.setLocality(addressDTO.getLocality());
        address.setDistrict(addressDTO.getDistrict());
        address.setStreet(addressDTO.getStreet());
        return addressRepository.save(address);
    }
}
