package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mappers.GroupMapper;
import com.kodilla.ecommercee.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @GetMapping(value = "getGroupById")
    public GroupDto getGroupById(@RequestParam Long groupId) throws GroupNotFoundException {
        Group group = groupService.getGroupById(groupId);
        return groupMapper.mapToGroupDto(group);
    }

    @PutMapping(value = "updateGroupById")
    public GroupDto updateGroupById(@RequestBody GroupDto groupDto) throws GroupNotFoundException {
        Group updatedGroup = groupService.updateGroup(groupMapper.mapToGroup(groupDto));
        return groupMapper.mapToGroupDto(updatedGroup);
    }
}
