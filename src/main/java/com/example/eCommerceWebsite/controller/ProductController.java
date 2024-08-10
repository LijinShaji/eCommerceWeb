package com.example.eCommerceWebsite.controller;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.models.productModel.ProductMediaMain;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
    ProductService productService;
@Autowired
    CategoryService categoryService;

@PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody MainProductDTO product) {
    Product newProduct=productService.createProduct(product);
    return ResponseEntity.ok().body(newProduct);
}
@PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryDTO category) {
    ProductCategory newCategory=categoryService.saveCategory(category);
    return ResponseEntity.ok(newCategory);
}

@PostMapping("")
    public ResponseEntity<ProductMediaMain> addProductMedia(@RequestBody ProductMediaMain productMedia) {
    return null;
    }
@PutMapping("")
    public ResponseEntity<?> updateProduct(@RequestBody MainProductDTO product, @RequestParam("id") long id) {
   Product newProduct= productService.updateProduct(product,id);
   if(newProduct!=null){
       return ResponseEntity.ok(newProduct);
   }else{
       ErrorResponseBody error=new ErrorResponseBody();
       error.setStatus(404);
       error.setErrorMessage("No product found for the entered product id");
       return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(error);
   }
}

@GetMapping("/{id}")
public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
    try {
        if(id<1){
            throw new IllegalArgumentException("Product ID is invalid");
        }
        Product product=productService.getProduct(id);
        return ResponseEntity.ok(product);
    }catch (Exception e) {
        ErrorResponseBody error=new ErrorResponseBody();
        error.setStatus(404);
        error.setErrorMessage("Error occurred"+e.getMessage());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(error);
    }

}
}

