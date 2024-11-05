package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.PutResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProdCategoryRepository;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    public PutResponseDTO saveCategory(CreateCategoryDTO categoryDTO) {
        PutResponseDTO putResponseDTO = new PutResponseDTO();
        ProductCategory productCategoryCheck = prodCategoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (productCategoryCheck == null) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setCategoryName(categoryDTO.getCategoryName());
            productCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
            ProductCategory category= prodCategoryRepository.findByCategoryName(categoryDTO.getParentCategoryName());
            if(category!=null){
                productCategory.setParentCategory(category);
            }else{
                putResponseDTO.setCode(401);
                putResponseDTO.setMessage("Category not found");
            }
            prodCategoryRepository.save(productCategory);
            putResponseDTO.setCode(200);
            putResponseDTO.setMessage("Category saved");
        }else{
            putResponseDTO.setCode(401);
            putResponseDTO.setMessage("Category already exists");
        }
        return putResponseDTO;
    }

    @Override
    public ArrayList<CreateCategoryDTO> findCategoriesFromParent(String categoryName) {
        ProductCategory category = prodCategoryRepository.findByCategoryName(categoryName);

        ArrayList<CreateCategoryDTO> productCategories = new ArrayList<>();
        ArrayList<ProductCategory> prodCategories=new ArrayList<>();
        if(category==null){
            prodCategories=prodCategoryRepository.findByParentCategoryNull();
        }else{
            prodCategories=prodCategoryRepository.findByParentCategory(category);
        }
        prodCategories.forEach(prodCategory -> {
            CreateCategoryDTO createCategoryDTO = new CreateCategoryDTO();
            createCategoryDTO.setCategoryName(prodCategory.getCategoryName());
            createCategoryDTO.setCategoryDescription(prodCategory.getCategoryDescription());
            productCategories.add(createCategoryDTO);
        });
        return productCategories;
    }


}
