package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.GenericEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public GenericEntity getCartById(@RequestParam Long cartId) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody GenericEntity cartDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public GenericEntity updateCart(@RequestBody GenericEntity cartDto) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCartById(@RequestParam Long cartId) {

    }

}

