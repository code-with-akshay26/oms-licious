package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        order.setStatus("CREATED");
        return repository.save(order);
    }

    public Order updateStatus(Long id, String status) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return repository.save(order);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }
}