package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.ServerEndpoint;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<GenericEntity> getOrders(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(GenericEntity orderDto){
        System.out.println("created order number "+orderDto.getId());
    }

    @RequestMapping(method = RequestMethod.GET, value= "showOrder", params = "id")
    public GenericEntity showOrder(@RequestParam int orderId){
        return new GenericEntity("test order");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public GenericEntity updateOrder(GenericEntity orderDto){
        return new GenericEntity("updated order");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder", params = "id")
    public void deleteOrder(@RequestParam int orderId){
        System.out.println("deleted order number "+orderId);
    }
}