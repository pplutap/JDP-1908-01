package com.kodilla.ecommercee.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "GROUPS")
public class Group {

    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", unique = true)
    private long groupId;

    @Setter
    @Column(name = "GROUP_NAME")
    private String groupName;
}
