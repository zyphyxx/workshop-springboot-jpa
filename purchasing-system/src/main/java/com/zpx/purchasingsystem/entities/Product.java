package com.zpx.purchasingsystem.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "categories_id",referencedColumnName = "id")
    @JsonDeserialize
    private Category categories;

}
