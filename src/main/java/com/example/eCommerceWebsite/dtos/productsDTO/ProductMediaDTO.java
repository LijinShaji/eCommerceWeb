package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.Review;
import lombok.Data;

@Data
public class ProductMediaDTO {
    private int id;
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String mediaURL;
    private String extension;
    private String type;
    private Product product;
    private Review review;
}
