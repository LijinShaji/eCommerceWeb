package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;

public interface ProductService {
    Product CreateProduct(CreateProductDTO productDTO);
    Product UpdateProduct( CreateProductDTO productDTO);

}
