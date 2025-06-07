package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    ProductCategory findCategoryById(Long id);
    ProductCategory findCategoryByName(String name);
    ResponseDTO saveCategory(CreateCategoryDTO categoryDTO);
    ArrayList<CreateCategoryDTO> findCategoriesFromParent(String categoryName);
    Set<String> searchCategories(String categoryName);
}
