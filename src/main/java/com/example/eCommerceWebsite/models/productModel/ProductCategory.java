package com.example.eCommerceWebsite.models.productModel;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    @OneToOne
    private ProductCategory parentCategory;
}
