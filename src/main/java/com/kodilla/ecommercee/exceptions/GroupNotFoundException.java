package com.kodilla.ecommercee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Group not found!")
public class GroupNotFoundException extends Exception {
}
