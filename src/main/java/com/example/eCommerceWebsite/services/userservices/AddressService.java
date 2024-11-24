package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.models.userModel.Address;

import java.util.List;

public interface AddressService {
    ResponseDTO saveAddress(AddressDTO address);
    List<AddressDTO> getCurrentUserAddresses();
    Address getAddressById(long id);
    Address updateAddress(AddressDTO address, long id);
}
