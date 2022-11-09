package com.example.onetomany.mapper;

import com.example.onetomany.entiry.ItemsEntity;
import com.example.onetomany.model.Items;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ItemsMapper {
    ItemsEntity itemsToEntity (Items items);
    Items entityToItems (ItemsEntity itemsEntity);

   //Set<ItemsEntity> itemsToEntityes ( Set<Items> items);
}
