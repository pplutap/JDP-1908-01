package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
