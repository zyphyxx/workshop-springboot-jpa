package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.entities.User;
import com.zpx.purchasingsystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser () {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser (User client) {
        return userRepository.save(client);
    }
}
