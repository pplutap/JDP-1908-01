package com.kodilla.ecommercee;

import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public GenericEntity createUser(@RequestParam Long userId) throws UserNotFoundException {
        return new GenericEntity("test Create User");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam Long userId) throws UserNotFoundException {
    }

    @RequestMapping(method = RequestMethod.POST, value = "generateKey")
    public String generateKey(@RequestBody GenericEntity userDTO) throws UserNotFoundException {
        return "test key";
    }
}
