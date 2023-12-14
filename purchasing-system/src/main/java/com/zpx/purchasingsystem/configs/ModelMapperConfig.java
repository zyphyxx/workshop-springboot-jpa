package com.zpx.purchasingsystem.configs;

import com.zpx.purchasingsystem.domains.Product;
import com.zpx.purchasingsystem.domains.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper mapper () {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Product.class, ProductDTO.class);

        return modelMapper;
    }
}
