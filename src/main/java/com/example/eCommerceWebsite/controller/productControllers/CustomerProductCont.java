package com.example.eCommerceWebsite.controller.productControllers;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class CustomerProductCont {

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return null;
    }
}


