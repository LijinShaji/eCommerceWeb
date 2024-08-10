package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductMediaMain;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ReviewDTO {
    private long id;
    private String title;
    private String comments;
    private int rating;
    private Set<ProductMediaMain> reviewedMedia = new HashSet<>();
    private Product product;
}
