package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.GenericEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST,value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody GenericEntity cartDto){
    }

    @RequestMapping(method = RequestMethod.GET,value = "getProducts")
    public List<GenericEntity> getProductsFromCart(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST,value = "addProducts")
    public void addProductsToCart(@RequestBody List<GenericEntity> productDto){

    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteProduct")
    public void deleteProductByName(@RequestParam String name){

    }

    @RequestMapping(method = RequestMethod.POST,value = "createOrder")
    public void createOrder(@RequestBody GenericEntity orderDto){

    }
}
