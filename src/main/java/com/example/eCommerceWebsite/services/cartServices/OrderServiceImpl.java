package com.example.eCommerceWebsite.services.cartServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CartDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.OrderDTO;
import com.example.eCommerceWebsite.models.productModel.cart.CartOrder;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.productRepo.OrderRepository;
import com.example.eCommerceWebsite.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final CartService cartService;

    @Autowired
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService, UserService userService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.userService = userService;
    }

    @Override
    public CartOrder getOrder(String orderId) {
        return null;
    }

    @Override
    public ArrayList<CartOrder> getAllOrders(String customerId) {
        return null;
    }

    @Override
    public CartDTO createOrder(OrderDTO order) {
        User user=userService.getCurrentUser();
        CartOrder newOrder=new CartOrder();
        newOrder.setCartID(order.getCart_id());
        newOrder.setUserID(user.getUser_id());
        newOrder.setPaymentDone(false);
        orderRepository.save(newOrder);

       return cartService.getCartByCartId(order.getCart_id());
    }
}
