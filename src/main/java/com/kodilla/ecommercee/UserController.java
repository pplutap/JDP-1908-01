package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mappers.UserMapper;
import com.kodilla.ecommercee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUserById(@RequestParam Long userId) throws UserNotFoundException {
        userMapper.mapToUserDto(userService.blockUserById(userId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "generateKey")
    public void generateKey(@RequestBody String username) throws UserNotFoundException {
        userMapper.mapToUserDto(userService.generateKey(username));
    }

}
