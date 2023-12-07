package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.Product;
import com.zpx.purchasingsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts () {
        List<Product> objs = productService.findAllProducts();
       return ResponseEntity.ok().body(objs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findProductById (@PathVariable Long id) {
        Optional<Product> obj = productService.findProductById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct (@RequestBody Product products){
        Product newObj = productService.createProduct(products);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    @PutMapping("/{id}")
    public void updateProduct (@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
         productService.updateProduct(product);
    }




}
