package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(MainProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        ProductCategory category = categoryService.findCategoryById(productDTO.getCategoryId());
        product.setCategoryDetail(category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(MainProductDTO productDTO, long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product!=null){
            if(productDTO.getTitle()!=null){
                product.setTitle(productDTO.getTitle());
            }
            if(productDTO.getDescription()!=null){
                product.setDescription(productDTO.getDescription());
            }
           ProductCategory category= categoryService.findCategoryById(productDTO.getCategoryId());
            if(category!=null){
                product.setCategoryDetail(category);
            }
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
