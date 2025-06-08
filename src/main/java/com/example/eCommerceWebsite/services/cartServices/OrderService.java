package com.example.eCommerceWebsite.services.cartServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CartDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.OrderDTO;
import com.example.eCommerceWebsite.models.productModel.cart.CartOrder;

import java.util.ArrayList;

public interface OrderService {
    public CartOrder getOrder(String orderId);
    public ArrayList<CartOrder> getAllOrders(String customerId);
    public CartDTO createOrder(OrderDTO order);
}
