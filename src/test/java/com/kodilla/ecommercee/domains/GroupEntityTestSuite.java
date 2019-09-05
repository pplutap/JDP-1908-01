package com.kodilla.ecommercee.domains;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    GroupRepository repository;

    @Test
    public void groupSaveTest(){
        //Given
        Group group = new Group("test group");
        Product productOne = new Product("test product 1", "test description 1", 1L, group);
        Product productTwo = new Product("test product 2", "test description 2", 2L, group);
        Product productThree = new Product("test product 3", "test description 3", 3L, group);
        group.getProducts().add(productOne);
        group.getProducts().add(productTwo);
        group.getProducts().add(productThree);

        //When
        repository.save(group);
        long id = group.getGroupId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void groupReadTest() throws GroupNotFoundException {
        //Given
        Group group = new Group("test group");
        Product productOne = new Product("test product 1", "test description 1", 1L, group);
        Product productTwo = new Product("test product 2", "test description 2", 2L, group);
        Product productThree = new Product("test product 3", "test description 3", 3L, group);
        group.getProducts().add(productOne);
        group.getProducts().add(productTwo);
        group.getProducts().add(productThree);

        //When
        repository.save(group);
        long id = group.getGroupId();

        //Then
        Group resultGroup = repository.findById(id).orElseThrow(GroupNotFoundException::new);

        Assert.assertEquals("test group", resultGroup.getGroupName());
        Assert.assertEquals(3, resultGroup.getProducts().size());

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void groupUpdateTest() throws GroupNotFoundException {
        //Given
        Group group = new Group("test group");
        Product productOne = new Product("test product 1", "test description 1", 1L, group);
        Product productTwo = new Product("test product 2", "test description 2", 2L, group);
        Product productThree = new Product("test product 3", "test description 3", 3L, group);
        group.getProducts().add(productOne);
        group.getProducts().add(productTwo);
        group.getProducts().add(productThree);

        //When
        repository.save(group);
        long id = group.getGroupId();

        Group updatedGroup = repository.findById(id).orElseThrow(GroupNotFoundException::new);
        updatedGroup.setGroupName("updated group");

        repository.save(updatedGroup);
        Group result = repository.findById(id).orElseThrow(GroupNotFoundException::new);
        //Then

        Assert.assertEquals("updated group", result.getGroupName());

        //Clean Up
        repository.deleteById(id);
    }

    public void groupDeleteTest() throws GroupNotFoundException {
        //Given
        Group group = new Group("test group");
        Product productOne = new Product("test product 1", "test description 1", 1L, group);
        Product productTwo = new Product("test product 2", "test description 2", 2L, group);
        Product productThree = new Product("test product 3", "test description 3", 3L, group);
        group.getProducts().add(productOne);
        group.getProducts().add(productTwo);
        group.getProducts().add(productThree);

        //When
        repository.save(group);
        long id = group.getGroupId();
        long countBeforeDelete = repository.count();

        //Then
        repository.deleteById(id);
        long countAfterDelete = repository.count();

        Assert.assertEquals(countBeforeDelete - 1, countAfterDelete);
    }
}
