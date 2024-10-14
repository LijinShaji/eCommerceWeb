package com.example.eCommerceWebsite.repository.productRepo;

import com.example.eCommerceWebsite.models.productModel.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductPageRepository extends PagingAndSortingRepository<Product,Long> {
    List<Product> findAllByTitleContaining(String title);
}
