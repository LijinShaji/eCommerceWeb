package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;

import java.util.ArrayList;

public interface CategoryService {
    ProductCategory findCategoryById(Long id);
    ResponseDTO saveCategory(CreateCategoryDTO categoryDTO);
    ArrayList<CreateCategoryDTO> findCategoriesFromParent(String categoryName);
}
