package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID", unique = true)
    private Long cartId;

    @Getter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Column(name = "DESCRIPTION")
    private String description;

    @Getter
    @Column(name = "PRICE")
    private long price;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products;
}
