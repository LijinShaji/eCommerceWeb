package com.example.eCommerceWebsite.services.cartServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CartDTO;
import com.example.eCommerceWebsite.models.productModel.cart.Cart;
import com.example.eCommerceWebsite.models.userModel.User;

public interface CartService {
    CartDTO addToCart(long user, Long productId, int quantity);
    CartDTO getCart(long user);
    CartDTO removeFromCart(long user, Long productId);
    CartDTO getCartByCartId(long id);
}
