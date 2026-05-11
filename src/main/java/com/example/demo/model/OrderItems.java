package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
}