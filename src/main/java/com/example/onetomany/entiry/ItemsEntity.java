package com.example.onetomany.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "items_id")
    private Long itemId;
    private String itemName;
    private Long quantity;
    private Long price;

    @ManyToOne
    @JoinColumn(name = "cart_id_fk")
    private CartEntity cart;



}
