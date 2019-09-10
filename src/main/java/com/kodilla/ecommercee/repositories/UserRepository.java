package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername (String username);

}
