package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.domains.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto){
        return new User (
                userDto.getUsername(),
                userDto.isStatus(),
                userDto.getOrders()
        );
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.isStatus(),
                user.getUserKey(),
                user.getOrders()
        );
    }
}
