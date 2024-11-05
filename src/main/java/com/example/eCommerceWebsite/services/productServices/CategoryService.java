package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.PutResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface CategoryService {
    ProductCategory findCategoryById(Long id);
    PutResponseDTO saveCategory(CreateCategoryDTO categoryDTO);
    ArrayList<CreateCategoryDTO> findCategoriesFromParent(String categoryName);
}
