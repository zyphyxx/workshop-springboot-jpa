package com.zpx.purchasingsystem.entities;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "categories")
    @JsonTypeId
    private List<Product> product;

}
