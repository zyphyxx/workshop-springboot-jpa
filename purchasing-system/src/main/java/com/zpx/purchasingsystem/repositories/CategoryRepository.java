package com.zpx.purchasingsystem.repositories;

import com.zpx.purchasingsystem.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
}
