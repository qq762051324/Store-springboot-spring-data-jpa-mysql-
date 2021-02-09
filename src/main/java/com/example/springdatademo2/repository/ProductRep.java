package com.example.springdatademo2.repository;

import com.example.springdatademo2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product,Integer> {
}
