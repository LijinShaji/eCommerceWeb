package com.example.eCommerceWebsite.dtos.productsDTO;

import lombok.Data;

import java.util.List;

@Data
public class CommonSeachDTO {
    boolean queryResult;
    List<ProductDTO> products;
}
