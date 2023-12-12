package com.zpx.purchasingsystem.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

;

@Entity
@Table(name = "tb_product")
@Data
public class Product  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    @ManyToMany (mappedBy = "products",cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(mappedBy = "items",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

}
