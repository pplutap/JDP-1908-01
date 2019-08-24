package com.kodilla.ecommercee;

import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

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
    public String generateKey(@RequestBody GenericEntity userDTO) throws UserNotFoundException {
        return "";
    }
}
