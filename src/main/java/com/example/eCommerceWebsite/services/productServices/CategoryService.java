package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;

import java.util.HashSet;
import java.util.List;

public interface CategoryService {
    ProductCategory findCategoryById(Long id);
    ProductCategory findCategoryByName(String name);
    HashSet<ProductCategory> findAllCategories();
    ProductCategory saveCategory(CreateCategoryDTO categoryDTO);
    void deleteCategory(ProductCategory category);
    ProductCategory updateCategory(ProductCategory category);
}
