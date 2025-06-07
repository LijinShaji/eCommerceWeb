package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProdCategoryRepository;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SelfCategoryService implements CategoryService {

    private final ProdCategoryRepository prodCategoryRepository;
    private final ProductRepository productRepository;


    public SelfCategoryService(ProdCategoryRepository prodCategoryRepository, ProductRepository productRepository) {
        this.prodCategoryRepository = prodCategoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public ProductCategory findCategoryById(Long id) {
        System.out.println(id);
        return prodCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ProductCategory findCategoryByName(String name) {
        return prodCategoryRepository.findByCategoryName(name);
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
            this.getChildCategory(category,prodCategories);
            prodCategories.add(category);
            System.out.println("prodCategories");
        }
        prodCategories.forEach(prodCategory -> {
            CreateCategoryDTO createCategoryDTO = new CreateCategoryDTO();
            createCategoryDTO.setCategoryName(prodCategory.getCategoryName());
            createCategoryDTO.setCategoryDescription(prodCategory.getCategoryDescription());
            createCategoryDTO.setParentCategoryName(categoryName);
            productCategories.add(createCategoryDTO);
        });
        return productCategories;
    }

    @Override
    public Set<String> searchCategories(String categoryName) {
        Set<String> productCategories = new HashSet<>();
        System.out.println("test");
        productCategories.addAll(this.getCatNameArr(prodCategoryRepository.findByCategoryNameContaining(categoryName)));
        productCategories.addAll(this.getCatNameArr(prodCategoryRepository.findByCategoryNameStartingWith(categoryName)));
        productCategories.addAll(this.getCatNameArr(prodCategoryRepository.findByCategoryNameEndingWith(categoryName)));
        System.out.println("productCategories");
        productCategories.forEach(productCategory -> {
            ArrayList<CreateCategoryDTO> catNameArr = this.findCategoriesFromParent(productCategory);
                productCategories.addAll(this.getCatNameCatDTO(catNameArr));
                System.out.println("productCategories");
                });
        return productCategories;
    }
    private ArrayList<String> getCatNameArr(ArrayList<ProductCategory> productCategories) {
        ArrayList<String> catNameArr = new ArrayList<>();
        productCategories.forEach(productCategory -> {
            catNameArr.add(productCategory.getCategoryName());
        });
        return catNameArr;
    }
    private ArrayList<String> getCatNameCatDTO(ArrayList<CreateCategoryDTO> createCategoryDTO) {
        ArrayList<String> catNameCatDTO = new ArrayList<>();
        createCategoryDTO.forEach(createCategoryDTO1 -> {
            catNameCatDTO.add(createCategoryDTO1.getCategoryName());
        });
        return catNameCatDTO;
    }
    private void getChildCategory(ProductCategory productCategory, ArrayList<ProductCategory> productCategories) {
   if(productCategory!=null){
       ArrayList<ProductCategory> childCategories= prodCategoryRepository.findByParentCategory(productCategory);
       childCategories.forEach(childCategory -> {
           productCategories.add(childCategory);
           getChildCategory(childCategory, productCategories);
       });
   }
    }

}
