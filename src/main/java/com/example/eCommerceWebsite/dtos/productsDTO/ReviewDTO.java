package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.ProductMedia;
import com.example.eCommerceWebsite.models.productModel.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ReviewDTO {
    private long id;
    private String title;
    private String comments;
    private int rating;
    private Set<ProductMedia> reviewedMedia = new HashSet<>();
    private Product product;
}
