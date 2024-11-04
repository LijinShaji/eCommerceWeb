package com.example.eCommerceWebsite.models.productModel;

import com.example.eCommerceWebsite.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class ProductMediaMain extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String mediaURL;
    private String extension;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "id")
    @JsonIgnore
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="review_id",referencedColumnName = "id")
    @JsonIgnore
    private Review review;
}
