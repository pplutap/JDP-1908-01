package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(final User user) {
        return repository.save(user);
    }

    public User blockUserById(final Long userId) throws UserNotFoundException {
        User blockUser = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        blockUser.setStatus(0);
        return repository.save(blockUser);
    }

    public User generateKey(final String username) throws UserNotFoundException {
        SecureRandom rand = new SecureRandom();
        long randomUserKey = (long)rand.nextInt(90000) + (long)10000;

        User user = repository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        user.setUserKey(randomUserKey);
        return repository.save(user);
    }
}
