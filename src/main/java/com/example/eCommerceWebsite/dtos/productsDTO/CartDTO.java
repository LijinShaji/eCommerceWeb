package com.example.eCommerceWebsite.dtos.productsDTO;

import com.example.eCommerceWebsite.models.productModel.cart.CartItem;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {

    private Long id;
    private Long userID;
    private List<CartItemDTO> items = new ArrayList<>();
    private double totalPrice;
}
