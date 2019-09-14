package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDto {
    private long orderId;
    private User user;
    private List<Product> products;
}
