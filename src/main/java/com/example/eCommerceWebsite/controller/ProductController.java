package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
    ProductService productService;
@Autowired
    CategoryService categoryService;

@PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDTO product) {
    Product newProduct=productService.CreateProduct(product);
    return ResponseEntity.ok().body(newProduct);
}
@PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryDTO category) {
    ProductCategory newCategory=categoryService.saveCategory(category);
    return ResponseEntity.ok(newCategory);
}

}

