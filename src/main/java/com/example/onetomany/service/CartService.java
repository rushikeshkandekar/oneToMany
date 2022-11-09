package com.example.onetomany.service;

import com.example.onetomany.entiry.CartEntity;
import com.example.onetomany.entiry.ItemsEntity;
import com.example.onetomany.mapper.CartMapper;
import com.example.onetomany.mapper.ItemsMapper;
import com.example.onetomany.model.Cart;
import com.example.onetomany.model.CartResponse;
import com.example.onetomany.model.Items;
import com.example.onetomany.repository.CartRepository;
import com.example.onetomany.repository.ItemsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CartService {

    private final ItemsRepository itemsRepository;
    private final CartRepository cartRepository;
    private final ItemsMapper itemsMapper;
    private final CartMapper cartMapper;

    public CartService(ItemsRepository itemsRepository, CartRepository cartRepository, ItemsMapper itemsMapper, CartMapper cartMapper) {
        this.itemsRepository = itemsRepository;
        this.cartRepository = cartRepository;
        this.itemsMapper = itemsMapper;

        this.cartMapper = cartMapper;
    }

    public CartResponse createCart(Cart cart) {
        CartEntity cartEntity = null;
        cartEntity = cartMapper.cartToEntity(cart);
        cartRepository.save(cartEntity);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartEntity.getCartId());
        log.info("created successfull with id {}", cartResponse);
        return cartResponse;
    }

    public Cart getById(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        Cart cart = new Cart();
        if (cartEntity.isPresent()) {
            cart = cartMapper.entityToCart(cartEntity.get());
            log.info("cart found with id {}", cartId);
        } else {
            log.info("cart with id {} not found", cartId);
        }
        return cart;
    }

    public void deleteById(Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        if (cartEntity.isPresent()) {
            cartRepository.deleteById(cartId);
            log.info("cart with id {} delete successfull", cartId);
        } else {
            log.info("cart with id {} not found", cartId);
        }

    }

    public Cart updateById(Cart cart, Long cartId) {
        Optional<CartEntity> cartEntity = cartRepository.findById(cartId);
        if (cartEntity.isPresent()) {}
            CartEntity cartEntity1 = cartMapper.cartToEntity(cart);
            cartEntity1.setCartId(cartId);

            for (ItemsEntity item : cartEntity.get().getItems()) {
                item.setCart(cartEntity1);
            }
            cartRepository.save(cartEntity1);
            cart=  cartMapper.entityToCart(cartEntity1);



            return cart;
        }

    }