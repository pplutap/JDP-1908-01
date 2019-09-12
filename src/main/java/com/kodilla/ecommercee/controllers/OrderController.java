package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domains.OrderDto;
import com.kodilla.ecommercee.mappers.OrderMapper;
import com.kodilla.ecommercee.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    @Autowired
    private OrderMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return mapper.mapToOrderDtoList(service.getOrders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
        service.saveOrder(mapper.mapToOrder(orderDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "showOrder")
    public OrderDto showOrder(@RequestParam long orderId) {
        return mapper.mapToOrderDto(service.getOrderById(orderId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return mapper.mapToOrderDto(service.saveOrder(mapper.mapToOrder(orderDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam long orderId) {
        service.deleteOrder(orderId);
    }
}