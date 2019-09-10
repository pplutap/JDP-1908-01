package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface GroupRepository extends CrudRepository <Group, Long> {

    @Override
    List<Group> findAll();
}
