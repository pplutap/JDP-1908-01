package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepositorySave() {
        //Given
        User user = new User("Mark", "active", 123456L);

        //When
        userRepository.save(user);
        long id = user.getId();

        //Then
        Assert.assertEquals(4, id);

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryRead() throws UserNotFoundException {
        //Given
        User user = new User("Mark", "active", 123456L);

        //When
        userRepository.save(user);
        long id = user.getId();

        //Then
        User readUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Assert.assertEquals("Mark", readUser.getUsername());
        Assert.assertEquals("active", readUser.getStatus());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryUpdate() throws UserNotFoundException {
        //Given
        User user = new User("Mark", "active", 123456L);
        userRepository.save(user);
        long id = user.getId();

        //When
        User userToUpdate = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userToUpdate.setUsername("Tanya");
        userRepository.save(userToUpdate);

        //Then
        User userFinal = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Assert.assertEquals("Tanya", userFinal.getUsername());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryDelete() {
        //Given
        User user = new User("Mark", "active", 123456L);
        userRepository.save(user);
        Long id = user.getId();

        //When
        userRepository.deleteById(id);

        //Then
        Assert.assertEquals(0L, userRepository.count());

    }
}
