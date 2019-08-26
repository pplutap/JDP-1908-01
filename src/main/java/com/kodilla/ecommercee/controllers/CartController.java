package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.GenericEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody GenericEntity cartDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public GenericEntity getCartById(@RequestParam Long cartId) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProducts")
    public void addProductsToCart(@RequestBody List<GenericEntity> productDto, @RequestParam Long cartId) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCartById(@RequestParam Long cartId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestParam Long cartId) {

    }
}
