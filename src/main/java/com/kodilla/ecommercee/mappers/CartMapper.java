package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public Cart mapToCart(CartDto cartDto) {
        return new Cart();
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getCartId(),
                cart.getUser(),
                cart.getProducts());
    }
}
