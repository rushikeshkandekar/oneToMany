package com.example.onetomany.mapper;

import com.example.onetomany.entiry.CartEntity;
import com.example.onetomany.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartEntity cartToEntity (Cart cart);
    Cart entityToCart(CartEntity cartEntity);
}
