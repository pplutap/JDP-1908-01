package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
