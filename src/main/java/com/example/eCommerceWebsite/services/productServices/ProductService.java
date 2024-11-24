package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import org.apache.coyote.Response;

import java.util.List;

public interface ProductService {
    ResponseDTO createProduct(ProductDTO productDTO);
    ResponseDTO updateProduct(ProductDTO productDTO, long id);
    List<ProductDTO> getAllProducts();
}
