package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.domains.Order;
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

    public Optional<Order> findOrderById (Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        obj.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return obj;
    }

    @Transactional
    public Order createOrder (Order orders) {
        return orderRepository.save(orders);
    }

    @Transactional
    public Order updateOrder (Order orders) {
        findOrderById(orders.getId());
        return orderRepository.save(orders);
    }


}
