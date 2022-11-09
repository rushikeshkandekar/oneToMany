package com.example.onetomany.controller;

import com.example.onetomany.model.Items;
import com.example.onetomany.service.ServiceTwo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerTwo {
    private final ServiceTwo serviceTwo;

    public ControllerTwo(ServiceTwo serviceTwo) {
        this.serviceTwo = serviceTwo;
    }
    @PutMapping(path = "/carts/{name}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Items> updateCart( @RequestBody Items items, @PathVariable String name)  {
         serviceTwo.updateCart(items,name);

       return ResponseEntity.ok().build();
    }
}
