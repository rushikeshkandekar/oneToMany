package com.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String firstName;
    private String lastName;
    private List<Items> items;
}
