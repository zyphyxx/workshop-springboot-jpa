package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.domains.Product;
import com.zpx.purchasingsystem.domains.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public List<ProductDTO> findAllProducts();

    public Optional<ProductDTO> findProductById(Long id);

    public Product createProduct (ProductDTO products);

    public Void updateProduct (ProductDTO product);

}
