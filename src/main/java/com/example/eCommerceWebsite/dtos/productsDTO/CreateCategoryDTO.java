package com.example.eCommerceWebsite.dtos.productsDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class CreateCategoryDTO {
    private String categoryName;
    private long parentCategory;
    private String categoryDescription;
}