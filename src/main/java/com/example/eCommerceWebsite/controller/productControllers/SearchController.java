package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.SearchRequestDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import com.example.eCommerceWebsite.services.searchServices.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    @Autowired
private final SearchService searchService;
    private final ProductRepository productRepository;

    @GetMapping("")
    public List<ProductDTO> searchProductsCommon(@RequestParam(name = "query") String query){
        return searchService.searchProductCommon(query);
    }


}
