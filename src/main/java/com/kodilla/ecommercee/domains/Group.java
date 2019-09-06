package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Product> products = new ArrayList<>();

}
