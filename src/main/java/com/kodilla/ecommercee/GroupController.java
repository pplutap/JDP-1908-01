package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GenericEntity> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(GenericEntity groupDto){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupById")
    public GenericEntity getGroupById (Long productGroupById){
        return new GenericEntity("Products Group 01");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroupById")
    public GenericEntity updateGroupById(GenericEntity groupDto){
        return new GenericEntity();
    }
}
