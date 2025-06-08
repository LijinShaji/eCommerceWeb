package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.cart.Cart;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private String product;
    private int quantity;
    private double price; // product.getPrice() * quantity
}
