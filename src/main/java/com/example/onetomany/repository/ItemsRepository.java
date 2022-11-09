package com.example.onetomany.repository;

import com.example.onetomany.entiry.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {
    ItemsEntity findByName(String name);
}
