package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository <Group, Long> {
}
