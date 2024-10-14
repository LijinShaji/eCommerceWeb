package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.MainProductDTO;
import com.example.eCommerceWebsite.models.ErrorResponseBody;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prod")
public class CustomerProductCont {
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

@PutMapping("")
public ResponseEntity<Product> updateProduct(@RequestParam("id") Long id,@RequestBody MainProductDTO product) {
    System.out.println("triggeredUpdateProduct");
    return null;
}
@GetMapping("/all")
public ResponseEntity<List<Product>> getAllProducts(
        @RequestParam(value = "pagenNo",defaultValue = "0",required = false)int pageNo,
        @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize) {
    System.out.println("Inside all products");
    return new ResponseEntity<>(productService.getAllProducts(pageNo,pageSize), HttpStatus.OK);
}

@GetMapping("/demo")
public ResponseEntity<String> getDemoProducts() {
    return new ResponseEntity<>("Working",HttpStatus.OK);
}

@PutMapping("/getProduct")
    public ResponseEntity<?> updateProduct(@RequestBody MainProductDTO product, @RequestParam("id") long id) {
   System.out.println("test234");
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
@PostMapping("/multiProducts")
    public ResponseEntity<?> addMultiProducts(@RequestBody List<MainProductDTO> productDTOList) {
    List<Product> products=new ArrayList<>();
    for(MainProductDTO productDTO:productDTOList){
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        products.add(product);
    }
    productService.addMultipleProducts(products);
    return ResponseEntity.ok().body(products);
}
}


