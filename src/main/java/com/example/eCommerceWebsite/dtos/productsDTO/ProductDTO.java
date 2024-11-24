package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.media.MediaType;
import lombok.*;

import java.util.ArrayList;

@Data
public class ProductDTO {
        private String title;
        private float price;
        private long categoryID;
        private int overallRating;
        private String description;
        private String imageUrl;
        private String imageName;
        private MediaType mediaType;
}
