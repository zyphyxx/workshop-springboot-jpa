package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.entities.Order;
import com.zpx.purchasingsystem.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrder () {
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder (Order orders) {
        return orderRepository.save(orders);
    }
}
