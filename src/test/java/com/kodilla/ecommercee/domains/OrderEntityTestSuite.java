package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {

    @Autowired
    OrderRepository repository;

    @Test
    public void orderSaveTest(){
        //Given
        User user = new User("Thomas",1);
        Order order = new Order(user);

        //When
        repository.save(order);
        long id = order.getId();

        //Then
        Assert.assertNotEquals(0,id);

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void orderReadTest() throws OrderNotFoundException {
        //Given
        User user = new User("Thomas",1);
        Order order = new Order(user);

        //When
        repository.save(order);
        long id = order.getId();

        Order result = repository.findById(id).orElseThrow(OrderNotFoundException::new);

        //Then
        Assert.assertEquals("Thomas",result.getUser().getUsername());
        Assert.assertNotEquals(null,result);
        Assert.assertNotEquals(0,result.getId(),0.001);

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void orderUpdateTest() throws OrderNotFoundException{
        //Given
        User user1 = new User("Thomas",1);
        User user2 = new User("Mark",1);
        Order order = new Order(user1);

        //When
        repository.save(order);
        long id = order.getId();

        Order updateOrder = repository.findById(id).orElseThrow(OrderNotFoundException::new);
        updateOrder.setUser(user2);

        repository.save(updateOrder);
        Order result = repository.findById(id).orElseThrow(OrderNotFoundException::new);

        //Then
        Assert.assertEquals("Mark",result.getUser().getUsername());

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void orderDeleteTest(){
        //Given
        User user = new User("Thomas",1);
        Order order = new Order(user);

        //When
        repository.save(order);
        long id = order.getId();
        long recordsNumberBeforeDeleteOrder = repository.count();

        repository.deleteById(id);
        long recordsNumberAfterDeleteOrder = repository.count();

        //Then
        Assert.assertEquals(recordsNumberBeforeDeleteOrder-1,recordsNumberAfterDeleteOrder);
    }
}
