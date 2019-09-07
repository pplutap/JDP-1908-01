package com.kodilla.ecommercee.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "USERS")
public class User {

    public User(String username, String status, Long userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "USERNAME")
    private String username;

    @Getter
    @Setter
    @Column(name = "STATUS")
    private String status;

    @Getter
    @Column(name = "USER_KEY")
    private Long userKey;

    @Getter
    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Order> orders = new ArrayList<>();
}
