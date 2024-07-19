package com.example.eCommerceWebsite.repository.productRepo;

import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
