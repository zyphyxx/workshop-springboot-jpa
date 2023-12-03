package com.zpx.purchasingsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double price;
}
