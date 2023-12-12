package com.zpx.purchasingsystem.repositories;

import com.zpx.purchasingsystem.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}
