package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.Product;
import com.zpx.purchasingsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAllProducts () {
       return productService.findAllProducts();
    }

    @PostMapping
    public Product createProduct (@RequestBody Product products){
        return productService.createProduct(products);
    }


}
