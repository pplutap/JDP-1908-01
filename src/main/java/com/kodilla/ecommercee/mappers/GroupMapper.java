package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public Group mapToGroup(final GroupDto groupDto) {
        Group group = new Group(
                groupDto.getGroupName()
        );
        group.setProducts(groupDto.getProducts());
        return group;
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(group.getGroupId(),
                group.getGroupName(),
                group.getProducts()
        );
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(g -> new GroupDto(g.getGroupId(), g.getGroupName(), g.getProducts()))
                .collect(Collectors.toList());
    }
}
