package com.example.eCommerceWebsite.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private int productID;
    private String productName;
    private String description;
    private String price;
    private Rating rating;
}
