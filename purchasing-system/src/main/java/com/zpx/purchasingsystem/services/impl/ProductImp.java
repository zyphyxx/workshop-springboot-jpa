package com.zpx.purchasingsystem.services.impl;

import com.zpx.purchasingsystem.domains.Product;
import com.zpx.purchasingsystem.domains.dto.ProductDTO;
import com.zpx.purchasingsystem.repositories.ProductRepository;
import com.zpx.purchasingsystem.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll()
                .stream().map(objs -> mapper.map(objs, ProductDTO.class)).toList();
    }

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
     return productRepository.findById(id).map(objId -> mapper.map(objId, ProductDTO.class));
    }

    @Override
    public Product createProduct(ProductDTO products) {
        return null;
    }

    @Override
    public Void updateProduct(ProductDTO product) {
        return null;
    }
}
