package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;

public interface ProductService {
    Product createProduct(MainProductDTO productDTO);
    Product updateProduct(MainProductDTO productDTO, long id);
    Product getProduct(Long id);

}
