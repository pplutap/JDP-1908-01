package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
