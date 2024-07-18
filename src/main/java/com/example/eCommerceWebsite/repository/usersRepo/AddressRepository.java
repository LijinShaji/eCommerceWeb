package com.example.eCommerceWebsite.repository.usersRepo;

import com.example.eCommerceWebsite.models.userModel.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
}
