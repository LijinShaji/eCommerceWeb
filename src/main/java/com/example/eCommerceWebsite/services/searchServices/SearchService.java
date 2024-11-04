package com.example.eCommerceWebsite.services.searchServices;

import com.example.eCommerceWebsite.dtos.productsDTO.SearchRequestDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SearchService {
    Page<Product> searchProduct(SearchRequestDTO searchRequestDTO);
}
