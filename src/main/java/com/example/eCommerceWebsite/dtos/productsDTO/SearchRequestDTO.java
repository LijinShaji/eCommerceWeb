package com.example.eCommerceWebsite.dtos.productsDTO;

import lombok.Data;

@Data
public class SearchRequestDTO {
    private String query;
    private int pageSize;
    private int page;
}
