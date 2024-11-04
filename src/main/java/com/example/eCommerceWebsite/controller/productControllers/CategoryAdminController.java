package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category_admin")
public class CategoryAdminController {

    @GetMapping("/categories")
    public String categories() {
        return "Categories";
    }
    @PostMapping("/categories")
    public String addCategory(@RequestBody ProductCategory category) {
        return category.toString();
    }
}
