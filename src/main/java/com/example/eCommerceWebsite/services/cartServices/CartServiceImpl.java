package com.example.eCommerceWebsite.services.cartServices;

import com.example.eCommerceWebsite.dtos.productsDTO.CartDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.CartItemDTO;
import com.example.eCommerceWebsite.dtos.productsDTO.ProductDTO;
import com.example.eCommerceWebsite.models.productModel.Product;
import com.example.eCommerceWebsite.models.productModel.cart.Cart;
import com.example.eCommerceWebsite.models.productModel.cart.CartItem;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.productRepo.CartItemRepository;
import com.example.eCommerceWebsite.repository.productRepo.CartRepository;
import com.example.eCommerceWebsite.repository.productRepo.ProductRepository;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import com.example.eCommerceWebsite.services.productServices.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Override
    public CartDTO addToCart(long user, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserID(user).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserID(user);
            return cartRepository.save(newCart);
        });



        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProductID().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            item.setPrice(product.getPrice() * item.getQuantity());
        } else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setProductID(product.getId());
            item.setQuantity(quantity);
            item.setPrice(product.getPrice() * quantity);
            cart.getItems().add(item);
        }

        // Recalculate total
        double total = cart.getItems().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
        cart.setTotalPrice(total);

        Cart savedCart= cartRepository.save(cart);
        return this.convertToCartDTO(savedCart);
    }
    @Override
    public CartDTO getCart(long user) {
        Cart cart = cartRepository.findByUserID(user).orElseThrow(() -> new RuntimeException("User not found"));
    return this.convertToCartDTO(cart);
    }

    private CartDTO convertToCartDTO(Cart cart) {

        CartDTO cartdto = new CartDTO();
        List<CartItem> cartItems=cart.getItems();
        List<CartItemDTO> cartItemDtos=new ArrayList<>();
        System.out.println("Test");
        cartItems.forEach(cartItem -> {
            Product product=productRepository.findById(cartItem.getProductID()).orElseThrow(() -> new RuntimeException("Product not found"));
            System.out.println("Test");

            CartItemDTO cartItemDTO=new CartItemDTO();
            cartItemDTO.setId(cartItem.getId());
            cartItemDTO.setQuantity(cartItem.getQuantity());
            cartItemDTO.setPrice(cartItem.getPrice());
            cartItemDTO.setProduct(product.getTitle());
            cartItemDtos.add(cartItemDTO);
        });
        cartdto.setItems(cartItemDtos);
        cartdto.setId(cart.getId());
        cartdto.setTotalPrice(cart.getTotalPrice());
        cartdto.setUserID(cart.getUserID());
        return  cartdto;
    }
    @Override
    public CartDTO removeFromCart(long userId, Long productId) {
        Cart cart = cartRepository.findByUserID(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));

        boolean removed = cart.getItems().removeIf(item -> item.getProductID().equals(productId));

        if (!removed) {
            throw new RuntimeException("Product not found in cart");
        }

        // Recalculate total
        double total = cart.getItems().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
        cart.setTotalPrice(total);

        // Save updated cart
        Cart savedCart = cartRepository.save(cart);

        return convertToCartDTO(savedCart);
    }

    @Override
    public CartDTO getCartByCartId(long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        System.out.println("Hi");
        return this.convertToCartDTO(cart);
    }

}


