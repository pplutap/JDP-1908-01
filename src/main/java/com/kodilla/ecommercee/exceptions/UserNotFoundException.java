package com.kodilla.ecommercee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User not found!")
=======
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Order not found")
>>>>>>> master
public class UserNotFoundException extends Exception {
}
