package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.models.Product;
import com.example.eCommerceWebsite.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping("/addproduct")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
    return productService.saveProduct(product);
    }
    @PostMapping("/addMultipleProducts")
    public String addMultipleProd(@RequestBody ArrayList<Product> productList){
        return productService.saveMultipleProduct(productList);
    }

}
