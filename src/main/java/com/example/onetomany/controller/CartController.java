package com.example.onetomany.controller;

import com.example.onetomany.model.Cart;
import com.example.onetomany.model.CartResponse;
import com.example.onetomany.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/carts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> createCarts(@RequestBody Cart cart) {
        CartResponse cartResponse = cartService.createCart(cart);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/carts/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getById(@PathVariable Long cartId) {
        Cart cart = cartService.getById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping(value = "/carts/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long cartId) {
        cartService.deleteById(cartId);
        log.info("deleted");
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/carts/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> updateById(@RequestBody Cart cart, @PathVariable Long cartId) {
        cart = cartService.updateById(cart, cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}

