package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {

    @Autowired
    UserRepository repository;

    @Test
    public void userSaveTest() {
        //Given
        List<Order> orders = new ArrayList<>();
        User user = new User("Mark", true, orders);

        //When
        repository.save(user);
        long id = user.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void userReadTest() throws UserNotFoundException {
        //Given
        List<Order> orders = new ArrayList<>();
        User user = new User("Mark", true, orders);

        //When
        repository.save(user);
        long id = user.getId();

        //Then
        User result = repository.findById(id).orElseThrow(UserNotFoundException::new);

        Assert.assertEquals("Mark", result.getUsername());
        Assert.assertEquals(true, result.isStatus());

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void userUpdateTest() throws UserNotFoundException {
        //Given
        List<Order> orders = new ArrayList<>();
        User user = new User("Mark", true, orders);

        //When
        repository.save(user);
        long id = user.getId();

        User updateUser = repository.findById(id).orElseThrow(UserNotFoundException::new);
        updateUser.setUsername("Tanya");

        repository.save(updateUser);
        User result = repository.findById(id).orElseThrow(UserNotFoundException::new);
        //Then

        Assert.assertEquals("Tanya", result.getUsername());

        //Clean Up
        repository.deleteById(id);
    }

    @Test
    public void userDeleteTest() {
        //Given
        //Given
        List<Order> orders = new ArrayList<>();
        User user = new User("Mark", true, orders);

        //When
        repository.save(user);
        long id = user.getId();
        long countBeforeDelete = repository.count();

        //Then
        repository.deleteById(id);
        long countAfterDelete = repository.count();

        Assert.assertEquals(countBeforeDelete - 1, countAfterDelete);
    }
}

