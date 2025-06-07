package com.example.eCommerceWebsite.services.searchServices;

import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.SearchRequestDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SelfSearchService implements SearchService {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public Page<Product> searchProduct(SearchRequestDTO searchRequestDTO){

        Pageable pageable = PageRequest.of(searchRequestDTO.getPage(), searchRequestDTO.getPageSize());
        return productRepository.findAllByTitleContaining(searchRequestDTO.getQuery(),pageable);
    }

    @Override
    public List<ProductDTO> searchProductCommon(String searchQuery) {
        List<Product> productsArr = new ArrayList<>(productService.searchProducts(searchQuery));

       Set<String> categories=categoryService.searchCategories(searchQuery);
       if(!categories.isEmpty()){
           categories.forEach(category -> {
               productsArr.addAll(productService.getProductsByCategory(category));
           });
       }
       System.out.println("Test");
       List<ProductDTO> productsDTO = new ArrayList<>();
       productsArr.forEach(
               product -> {
                   ProductDTO productDTO = new ProductDTO();
                   productDTO.setTitle(product.getTitle());
                   productDTO.setDescription(product.getDescription());
                   productDTO.setPrice(product.getPrice());
                   productsDTO.add(productDTO);
               }
       );
        return productsDTO;
    }



}
