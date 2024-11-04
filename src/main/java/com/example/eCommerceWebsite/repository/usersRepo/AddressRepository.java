package com.example.eCommerceWebsite.repository.usersRepo;

import com.example.eCommerceWebsite.models.userModel.Address;
import com.example.eCommerceWebsite.models.userModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
    List<Address> findAllByUser(User user);
}
