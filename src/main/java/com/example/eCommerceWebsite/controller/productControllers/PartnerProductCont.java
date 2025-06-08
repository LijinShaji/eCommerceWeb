package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PartnerProductCont {
    @Autowired
private final ProductService productService;

    @GetMapping("")
    public ProductDTO getProduct(){
        return null;
    }

    @PostMapping("")
    public ResponseDTO addProduct(@RequestBody ProductDTO productDTO){
     return productService.createProduct(productDTO);
    }
    @PostMapping("mproducts")
    public String addProducts(@RequestBody List<ProductDTO> productDTOList){
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        for(ProductDTO productDTO : productDTOList){
            responseDTOList.add(productService.createProduct(productDTO));
        }
        return "Added "+responseDTOList.toArray().length+" products to the list";
    }

    @GetMapping("/search")
    public ResponseDTO searchProduct(@RequestParam String searchQuery){
         return null;
    }
    @GetMapping("/all")
    public Page<ProductDTO> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {

        return productService.getPaginatedProducts(page, size);
    }
}
