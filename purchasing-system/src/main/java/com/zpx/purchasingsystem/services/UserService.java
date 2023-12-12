package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.domains.User;
import com.zpx.purchasingsystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User createUser(User client) {
        return userRepository.save(client);
    }

    @Transactional
    public void updateUser(User client) {
        Optional<User> obj = findUserById(client.getId());
        obj.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        userRepository.save(obj.get());
    }

    @Transactional
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }


}
