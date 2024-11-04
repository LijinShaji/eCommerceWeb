package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.commonDTO.PutResponseDTO;
import com.example.eCommerceWebsite.dtos.usersDTO.AddressDTO;
import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface AddressService {
    PutResponseDTO saveAddress(AddressDTO address);
    List<AddressDTO> getCurrentUserAddresses();
    Address getAddressById(long id);
    Address updateAddress(AddressDTO address, long id);
}
