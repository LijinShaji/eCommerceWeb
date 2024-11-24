package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.commonDTO.ResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("category_admin")
@RequiredArgsConstructor
public class CategoryAdminController {
@Autowired
private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(@RequestParam(required = false,name = "category") String categoryName) {
        ArrayList<CreateCategoryDTO> categories=categoryService.findCategoriesFromParent(categoryName);
        return ResponseEntity.ok(categories);
    }
    @PostMapping("/categories")
    public ResponseDTO addCategory(@RequestBody CreateCategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }
    @PostMapping("/mcategories")
    public List<ResponseDTO> addCategories(@RequestBody List<CreateCategoryDTO> categoryDTOList) {
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        categoryDTOList.forEach(categoryDTO -> {
            responseDTOList.add(categoryService.saveCategory(categoryDTO));
        });
        return responseDTOList;
    }
}
