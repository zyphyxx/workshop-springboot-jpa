package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.entities.Category;
import com.zpx.purchasingsystem.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
