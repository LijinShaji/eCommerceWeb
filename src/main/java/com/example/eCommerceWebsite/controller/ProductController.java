package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.models.productModel.Product;
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

}
