package com.example.eCommerceWebsite.services.productServices;

import com.example.eCommerceWebsite.models.productModel.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface ProductService {
    Product addProduct(Product product) throws ExecutionException, InterruptedException;
    ArrayList<String> addMultipleProducts(ArrayList<Product> products);
    Product getSingleProduct(int id);
    ArrayList<Product> getAllProducts();
}
