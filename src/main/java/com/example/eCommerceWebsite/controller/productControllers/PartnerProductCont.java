package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class PartnerProductCont {
    
private ProductService productService;

    @GetMapping("")
    public ProductDTO getProduct(){
        return null;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
        return null;
    }
}
