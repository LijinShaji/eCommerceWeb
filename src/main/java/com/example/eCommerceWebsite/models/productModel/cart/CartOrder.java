package com.example.eCommerceWebsite.models.productModel.cart;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cartID;
    private Long UserID;
    private double totalPrice;
    private boolean paymentDone;
}
