package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public Product CreateProduct(CreateProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        ProductCategory category = categoryService.findCategoryById(productDTO.getCategoryId());
        product.setCategoryDetail(category);
        return productRepository.save(product);
    }

    @Override
    public Product UpdateProduct(CreateProductDTO productDTO) {
        return null;
    }
}
