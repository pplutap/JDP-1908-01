package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
