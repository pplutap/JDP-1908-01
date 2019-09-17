package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.repositories.CartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void cartSaveTest(){
        //given
        Cart cart = new Cart();

        //when
        cartRepository.save(cart);
        long id = cart.getCartId();

        //then
        Assert.assertNotEquals(0, id);

        //cleanup
        cartRepository.deleteById(id);
    }

    @Test
    public void cartReadTest() throws CartNotFoundException{
        //given
        User user = new User("Test user", 9);
        Cart cart = new Cart();
        cart.setUser(user);

        //when
        cartRepository.save(cart);
        long id = cart.getCartId();

        Cart result = cartRepository.findById(id).orElseThrow(CartNotFoundException::new);

        //then
        Assert.assertEquals("Test user", result.getUser().getUsername());
        System.out.println(result.getUser().getUsername());

        //cleanup
        cartRepository.deleteById(id);
        System.out.println(result.getUser().getUsername()+" changed?");
    }

    @Test
    public void cartUpdateTest() throws CartNotFoundException{
        //given
        Cart cart = new Cart();

        //when
        cartRepository.save(cart);
        long id = cart.getCartId();

        Cart updatedCart = cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
        updatedCart.setUser(new User("Updated user", 9));

        cartRepository.save(updatedCart);

        //then
        Assert.assertEquals("Updated user", updatedCart.getUser().getUsername());

        //cleanup
        cartRepository.deleteById(id);
    }

    @Test
    public void cartDeleteTest(){
        //given
        Cart cart = new Cart();

        //when
        cartRepository.save(cart);
        long id = cart.getCartId();

        long countBeforeDelete = cartRepository.count();
        cartRepository.deleteById(id);
        long countAfterDelete = cartRepository.count();

        //then
        Assert.assertNotEquals(countAfterDelete, countBeforeDelete);
    }
}
