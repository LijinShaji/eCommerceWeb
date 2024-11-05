package com.example.eCommerceWebsite.controller.productControllers;

import com.example.eCommerceWebsite.dtos.commonDTO.PutResponseDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CreateCategoryDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import com.example.eCommerceWebsite.services.productServices.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
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
    public PutResponseDTO addCategory(@RequestBody CreateCategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }
    @PostMapping("/mcategories")
    public List<PutResponseDTO> addCategories(@RequestBody List<CreateCategoryDTO> categoryDTOList) {
        List<PutResponseDTO> responseDTOList = new ArrayList<>();
        categoryDTOList.forEach(categoryDTO -> {
            responseDTOList.add(categoryService.saveCategory(categoryDTO));
        });
        return responseDTOList;
    }
}
