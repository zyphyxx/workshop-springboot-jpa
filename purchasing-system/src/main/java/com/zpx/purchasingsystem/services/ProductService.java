package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.entities.Product;
import com.zpx.purchasingsystem.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAllProducts () {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById (Long id) {
        Optional<Product> obj = productRepository.findById(id);
        obj.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return obj;
    }

    @Transactional
    public Product createProduct (Product products) {
        return productRepository.save(products);
    }

}
