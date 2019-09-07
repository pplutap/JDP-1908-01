package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mappers.GroupMapper;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupRepository.save(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroupById")
    public GroupDto getGroupById(@RequestParam Long groupId) throws GroupNotFoundException {
        Group group = groupRepository.findById(groupId).orElseThrow(GroupNotFoundException::new);
        return groupMapper.mapToGroupDto(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroupById")
    public GroupDto updateGroupById(@RequestBody GroupDto groupDto) throws GroupNotFoundException {
        Group updateGroup = groupRepository.findById(groupDto.getGroupId()).orElseThrow(GroupNotFoundException::new);
        updateGroup.setGroupName(groupDto.getGroupName());
        updateGroup.setProducts(groupDto.getProducts());
        return groupMapper.mapToGroupDto(groupRepository.save(updateGroup));
    }
}
