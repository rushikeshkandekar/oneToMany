package com.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private String itemName;
    private Long quantity;
    private Long price;


}
