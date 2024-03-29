package com.example.onetomany.repository;

import com.example.onetomany.entiry.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
