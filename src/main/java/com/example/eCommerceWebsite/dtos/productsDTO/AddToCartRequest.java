package com.example.eCommerceWebsite.dtos.productsDTO;

import lombok.Data;

@Data
public class AddToCartRequest {
    private Long productId;
    private int quantity;
    // Getters and Setters
}
