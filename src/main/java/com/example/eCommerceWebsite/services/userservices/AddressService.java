package com.example.eCommerceWebsite.services.userservices;

import com.example.eCommerceWebsite.dtos.AddressDTO;
import com.example.eCommerceWebsite.models.userModel.Address;

public interface AddressService {
    Address saveAddress(Address address);
    Address getAddressById(long id);
    Address updateAddress(AddressDTO address, long id);
}
