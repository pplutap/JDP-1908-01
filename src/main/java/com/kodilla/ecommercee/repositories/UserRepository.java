package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    User save (User user);

    @Override
    Optional<User> findById (Long id);

    Optional<User> findUserByUsername (String username);

    @Override
    void deleteById (Long id);
}
