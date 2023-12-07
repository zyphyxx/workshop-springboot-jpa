package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.Order;
import com.zpx.purchasingsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAllOrder () {
        List<Order> objs = orderService.findAllOrder();
        return ResponseEntity.ok().body(objs);
    }

    @PostMapping
    public ResponseEntity <Order> createOrder (@RequestBody Order orders) {
        Order newObj = orderService.createOrder(orders);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findOrderById (@PathVariable Long id) {
        Optional<Order> obj = orderService.findOrderById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public Order updateOrder (@RequestBody Order orders, @PathVariable Long id){
        orders.setId(id);
        return orderService.updateOrder(orders);
    }
}
