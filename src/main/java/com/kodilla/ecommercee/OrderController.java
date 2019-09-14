package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<GenericEntity> getOrders(){
        return new ArrayList<>();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(GenericEntity orderDto){
        System.out.println("created order number "+orderDto.getId());
    }

    @GetMapping(value= "showOrder")
    public GenericEntity showOrder(@RequestParam int orderId){
        return new GenericEntity("test order");
    }

    @PutMapping( value = "updateOrder")
    public GenericEntity updateOrder(GenericEntity orderDto){
        return new GenericEntity("updated order");
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam int orderId){
        System.out.println("deleted order number "+orderId);
    }
}