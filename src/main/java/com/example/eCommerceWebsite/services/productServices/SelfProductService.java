package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseDTO createProduct(ProductDTO productDTO) {
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);

        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setMessage("Product created successfully");
        return responseDTO;
    }

    @Override
    public ResponseDTO updateProduct(ProductDTO productDTO, long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

}
