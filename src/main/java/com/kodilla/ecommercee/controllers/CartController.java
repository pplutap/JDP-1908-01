package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domains.CartDto;
import com.kodilla.ecommercee.domains.OrderDto;
import com.kodilla.ecommercee.domains.ProductDto;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.mappers.CartMapper;
import com.kodilla.ecommercee.mappers.OrderMapper;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartService service;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping(value = "getCart")
    public CartDto getCartById(@RequestParam Long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(service.getCart(cartId));
    }

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        service.saveCart(cartMapper.mapToCart(cartDto));
    }

    @PostMapping(value = "addProducts")
    public void addProductsToCart(@RequestBody List<ProductDto> productsDto, @RequestParam Long cartId) throws CartNotFoundException {
        service.addProductsToCart(productMapper.mapToProductList(productsDto), cartId);
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestParam Long cartId) throws CartNotFoundException {
        service.createOrderByCart(cartId);
    }

    @DeleteMapping(value = "deleteCart")
    public void deleteCartById(@RequestParam Long cartId) throws CartNotFoundException {
        service.deleteCart(cartId);
    }


}
