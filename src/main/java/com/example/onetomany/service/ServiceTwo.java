package com.example.onetomany.service;

import com.example.onetomany.entiry.ItemsEntity;
import com.example.onetomany.mapper.ItemsMapper;
import com.example.onetomany.model.Items;
import com.example.onetomany.repository.ItemsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ServiceTwo {
    private final ItemsRepository itemsRepository;
    private final ItemsMapper itemsMapper;

    public ServiceTwo(ItemsRepository itemsRepository, ItemsMapper itemsMapper) {
        this.itemsRepository = itemsRepository;
        this.itemsMapper = itemsMapper;
    }


    public void updateCart(Items item, String name) {

        ItemsEntity itemEntity = itemsRepository.findByName(name);
        if (itemEntity.getItemName().equalsIgnoreCase(name)) {
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setPrice(item.getPrice());
            itemsRepository.save(itemEntity);

        }
    }
}
