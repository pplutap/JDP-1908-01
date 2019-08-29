package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true)
    private Long orderId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private GenericEntity user;
    //TODO change GenericEntity to User entity, when it's done

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private List<Product> products;
}
