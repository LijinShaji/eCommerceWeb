package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.productsDTO.SearchRequestDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.services.searchServices.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
private final SearchService searchService;
    @PostMapping("/test")
    public ResponseEntity<Page<Product>> searchProducts(@RequestBody SearchRequestDTO searchDTO){
        Page<Product> products=searchService.searchProduct(searchDTO);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
