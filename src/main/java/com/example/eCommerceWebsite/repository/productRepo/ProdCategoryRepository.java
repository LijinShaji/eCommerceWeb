package com.example.eCommerceWebsite.repository.productRepo;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProdCategoryRepository extends JpaRepository<ProductCategory,Long> {
    ProductCategory findByCategoryName(String categoryName);
    ArrayList<ProductCategory> findByParentCategory(ProductCategory parentCategory);
    ArrayList<ProductCategory> findByParentCategoryNull();
    ArrayList<ProductCategory> findByCategoryNameContaining(String categoryName);
    ArrayList<ProductCategory> findByCategoryNameStartingWith(String categoryName);
    ArrayList<ProductCategory> findByCategoryNameEndingWith(String categoryName);

}
