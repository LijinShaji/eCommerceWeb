package com.example.eCommerceWebsite.models.productModel;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @ManyToMany
    @JoinTable(
            name = "m2m_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Product> products;
}
