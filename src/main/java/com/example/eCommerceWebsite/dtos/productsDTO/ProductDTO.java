package com.example.eCommerceWebsite.dtos.productsDTO;

import lombok.*;

@Data
public class ProductDTO {
        private String title;
        private float price;
        private long categoryID;
        private int overallRating;
        private String description;
        private long productMediaDTO;
}
