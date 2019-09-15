package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CartDto {

    private Long cartId;
    private User user;
    private List<Product> products;
}
