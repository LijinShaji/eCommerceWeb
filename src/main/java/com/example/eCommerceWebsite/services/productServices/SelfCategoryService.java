package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProdCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public ResponseDTO saveCategory(CreateCategoryDTO categoryDTO) {
        ResponseDTO putResponseDTO = new ResponseDTO();
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
