package com.example.eCommerceWebsite.repository.productRepo;

import com.example.eCommerceWebsite.models.productModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
