package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProdCategoryRepository;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService {

    private final ProdCategoryRepository prodCategoryRepository;


    public SelfCategoryService(ProdCategoryRepository prodCategoryRepository) {
        this.prodCategoryRepository = prodCategoryRepository;
    }
    @Override
    public ProductCategory findCategoryById(Long id) {
        return prodCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ProductCategory findCategoryByName(String name) {
        return null;
    }

    @Override
    public HashSet<ProductCategory> findAllCategories() {
        return null;
    }

    @Override
    public ProductCategory saveCategory(CreateCategoryDTO categoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(categoryDTO.getCategoryName());
        productCategory.setCategoryDescription(categoryDTO.getCategoryDescription());


        ProductCategory category= findCategoryById(categoryDTO.getParentCategory());
        if(category!=null){
            productCategory.setParentCategory(category);
        }

        return prodCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteCategory(ProductCategory category) {

    }

    @Override
    public ProductCategory updateCategory(ProductCategory category) {
        return null;
    }


}
