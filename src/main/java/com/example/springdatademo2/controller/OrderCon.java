package com.example.springdatademo2.controller;

import com.example.springdatademo2.dto.OrderReq;
import com.example.springdatademo2.dto.OrderRes;
import com.example.springdatademo2.entities.Product;
import com.example.springdatademo2.entities.User;
import com.example.springdatademo2.repository.CustomerRep;
import com.example.springdatademo2.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class OrderCon {
    @Autowired
    private CustomerRep customerRep;
    @Autowired
    private ProductRep productRep;

    public OrderReq data(){
        User user = new User();
        user.setName("yiwen");

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setName("cloth");
        product.setPid(1);
        products.add(product);

        user.setProducts(products);
        return new OrderReq(user);
    }

    @PostMapping("/placeHolder")
    public User placeHolder(@RequestBody OrderReq orderReq){
        return customerRep.save(customerRep.save(orderReq.getUser()));
    }

    @GetMapping("findAllOrder")
    public List<User> findAllOrder(){
        return customerRep.findAll();
    }

    @GetMapping("/response")
    public List<OrderRes> responseList(){
        return customerRep.response();
    }

}
