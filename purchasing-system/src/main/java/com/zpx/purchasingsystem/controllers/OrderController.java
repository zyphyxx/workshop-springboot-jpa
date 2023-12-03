package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.Order;
import com.zpx.purchasingsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAllOrder () {
        return orderService.findAllOrder();
    }

    @PostMapping
    public Order createOrder (@RequestBody Order orders) {
        return orderService.createOrder(orders);
    }
}
