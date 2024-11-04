package com.example.eCommerceWebsite.models;

import lombok.Data;

@Data
public class ErrorResponseBody {
    private int status;
    public String errorMessage;
}
