package com.example.eCommerceWebsite.services.searchServices;

import com.example.eCommerceWebsite.dtos.productsDTO.SearchRequestDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelfSearchService implements SearchService {

    private final ProductRepository productRepository;

    public Page<Product> searchProduct(SearchRequestDTO searchRequestDTO){

        Pageable pageable = PageRequest.of(searchRequestDTO.getPage(), searchRequestDTO.getPageSize());
        return productRepository.findAllByTitleContaining(searchRequestDTO.getQuery(),pageable);
    }

}
