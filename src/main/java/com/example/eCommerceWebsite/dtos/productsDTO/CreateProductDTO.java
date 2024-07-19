package com.example.eCommerceWebsite.dtos.productsDTO;

import lombok.Data;

@Data
public class CreateProductDTO {
    private String title;
    private String description;
    private float price;
    private long categoryId;

}
