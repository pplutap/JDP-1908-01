package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepositorySave() {
        //Given
        User user = new User(1L, "Mark", "active", 123456L, new ArrayList<>());

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        Assert.assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryUpdate() {
        //Given
        User user = new User(1L, "Mark", "active", 123456L, new ArrayList<>());
        userRepository.save(user);
        User user2 = new User(1L, "Tanya", "active", 123456L, new ArrayList<>());

        //When
        userRepository.save(user2);

        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        Assert.assertTrue(readUser.isPresent());
        Assert.assertEquals("Tanya", readUser.get().getUsername());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryDelete() {
        //Given
        User user = new User(1L, "Mark", "active", 123456L, new ArrayList<>());
        userRepository.save(user);
        Long id = user.getId();

        //When
        userRepository.deleteById(id);

        //Then
        Assert.assertEquals(0L, userRepository.count());

    }
}
