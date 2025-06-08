package com.example.eCommerceWebsite.controller.productControllers;
import com.example.eCommerceWebsite.dtos.productsDTO.AddToCartRequest;
import com.example.eCommerceWebsite.dtos.productsDTO.CartDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CartItemDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.OrderDTO;
import com.example.eCommerceWebsite.models.productModel.cart.Cart;
import com.example.eCommerceWebsite.models.productModel.cart.CartItem;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.services.cartServices.CartService;
import com.example.eCommerceWebsite.services.cartServices.OrderService;
import com.example.eCommerceWebsite.services.userservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService; // Assume you get the user from session/JWT

    @Autowired
    private OrderService orderService;
    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(@RequestBody AddToCartRequest request) {
        User user = userService.getCurrentUser(); // Assume implemented
        CartDTO updatedCart = cartService.addToCart(user.getUser_id(), request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(updatedCart);
    }

    @GetMapping("")
    public ResponseEntity<CartDTO> getCart() {

        User user = userService.getCurrentUser();
        return ResponseEntity.ok(cartService.getCart(user.getUser_id()));
    }
    @PostMapping("/remove")
    public ResponseEntity<CartDTO> removeCart(@RequestBody AddToCartRequest request){
        User user = userService.getCurrentUser();
        return ResponseEntity.ok(cartService.removeFromCart(user.getUser_id(), request.getProductId()));
    }
    @PostMapping("/order")
    public ResponseEntity<CartDTO> orderCart(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }
}
