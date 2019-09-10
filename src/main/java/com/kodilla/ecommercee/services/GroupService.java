package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    public Group getGroupById(Long id) throws GroupNotFoundException {
        return groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);
    }

    public Group updateGroup(Group group) throws GroupNotFoundException {
        Group updateGroup = groupRepository.findById(group.getGroupId()).orElseThrow(GroupNotFoundException::new);
        updateGroup.setGroupName(group.getGroupName());
        return updateGroup;
    }
}
