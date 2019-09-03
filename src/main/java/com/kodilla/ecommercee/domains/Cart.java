package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID", unique = true)
    private Long cartId;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products;
}
