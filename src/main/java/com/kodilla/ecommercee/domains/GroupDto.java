package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GroupDto {
    private long groupId;
    private String groupName;
    private List<Product> products;
}
