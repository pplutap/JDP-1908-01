package com.kodilla.ecommercee;

import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public GenericEntity getUser(@RequestParam Long id) throws UserNotFoundException {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam Long id) throws UserNotFoundException {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getKey")
    public String generateKey(@RequestParam Long id) throws UserNotFoundException {
        return "";
    }
}
