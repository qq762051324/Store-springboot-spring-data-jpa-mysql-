package com.example.springdatademo2.repository;

import com.example.springdatademo2.dto.OrderRes;
import com.example.springdatademo2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRep extends JpaRepository<User,Integer> {
    @Query("select new com.example.springdatademo2.dto.OrderRes(u.name,p.name) from User u join u.products p")
    List<OrderRes> response();
}
