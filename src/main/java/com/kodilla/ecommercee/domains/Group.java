package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Table(name = "GROUPS")
public class Group {

    private Long id;
    private String groupName;

    private List<Product> products = new ArrayList<>();

    public Group (){
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    public Long getId(){
        return id;
    }

    @NotNull
    @Column(name = "GROUP_NAME")
    public String getGroupName(){
        return groupName;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Product> getProducts (){
        return products;
    }
}
