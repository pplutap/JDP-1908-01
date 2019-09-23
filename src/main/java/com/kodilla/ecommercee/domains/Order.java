package com.kodilla.ecommercee.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "ORDERS")
public class Order {

    public Order(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @Getter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @Setter
    private User user;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    @Setter
    private List<Product> products = new ArrayList<>();

}
