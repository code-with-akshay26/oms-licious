package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        return service.updateStatus(id, request.get("status"));
    }

    @GetMapping
    public List<Order> getOrders() {
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrders().stream()
                .filter(o -> o.getOrderId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}