package com.example.eCommerceWebsite.models.productModel.cart;

import com.example.eCommerceWebsite.models.productModel.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cart cart;
    private Long productID;
    private int quantity;
    private double price; // product.getPrice() * quantity
}