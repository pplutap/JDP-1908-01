package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.config.AdminConfig;
import com.kodilla.ecommercee.domains.Mail;
import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.OrderDto;
import com.kodilla.ecommercee.mappers.OrderMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class EmailOrderService {

    private static final String SUBJECT = "Created new order";
    private static final String MESSAGE = "New order contains: ";
    private static final String END = " has just been created!";

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SimpleEmailService emailService;

    public Order createdOrder(final Order createOrder) {
        Order newOrder = orderService.saveOrder(createOrder);
        ofNullable(newOrder).ifPresent(orderC -> emailService.send(new Mail(adminConfig.getAdminMail(),
                SUBJECT, MESSAGE + orderC.getProducts() + END)));
        return newOrder;
    }
}