package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.repository.usersRepo.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class SelfAddressService implements AddressService {
    private final AddressRepository addressRepository;


    public SelfAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        Address newaddress= new Address();
        newaddress.setPinCode(address.getPinCode());
        newaddress.setState(address.getState());
        newaddress.setLocality(address.getLocality());
        newaddress.setDistrict(address.getDistrict());
        newaddress.setStreet(address.getStreet());
        newaddress.setUser(address.getUser());
        return addressRepository.save(newaddress);
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
