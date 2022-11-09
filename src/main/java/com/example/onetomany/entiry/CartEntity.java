package com.example.onetomany.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id_fk")
    private List<ItemsEntity> items;
}
