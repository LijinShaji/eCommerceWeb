package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ResponseDTO createProduct(ProductDTO productDTO);
    ResponseDTO updateProduct(ProductDTO productDTO, long id);
    List<ProductDTO> getAllProducts();
    List<Product> searchProducts(String searchText);
    List<Product> getProductsByCategory(String category);
    Page<ProductDTO> getPaginatedProducts(int page, int size);
}
