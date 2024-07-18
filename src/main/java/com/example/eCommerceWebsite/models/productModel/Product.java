package com.example.eCommerceWebsite.models.productModel;

import com.example.eCommerceWebsite.models.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private float price;
    @OneToOne
    private ProductCategory categoryDetail;
    private int overallRating;
    private String description;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private Set<ProductMedia> productMedia=new HashSet<>();
}
