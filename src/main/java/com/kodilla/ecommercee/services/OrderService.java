package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order getOrderById(final long id) {
        return repository.findById(id).orElse(null);
    }

    public Order saveOrder(final Order order) {
        return repository.save(order);
    }

    public void deleteOrder(final long id) {
        repository.deleteById(id);
    }
}
