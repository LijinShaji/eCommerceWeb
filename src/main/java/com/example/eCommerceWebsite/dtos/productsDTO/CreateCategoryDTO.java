package com.example.eCommerceWebsite.dtos.productsDTO;
import com.example.eCommerceWebsite.models.productModel.ProductCategory;
import lombok.Data;

@Data
public class CreateCategoryDTO {
    private String categoryName;
    private long parentCategory;
    private String categoryDescription;
}
