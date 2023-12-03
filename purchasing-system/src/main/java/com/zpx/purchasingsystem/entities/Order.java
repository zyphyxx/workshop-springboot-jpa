package com.zpx.purchasingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zpx.purchasingsystem.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private User client;

}
