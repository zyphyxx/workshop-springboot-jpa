package com.zpx.purchasingsystem.services.impl;

import com.zpx.purchasingsystem.domains.User;
import com.zpx.purchasingsystem.domains.dto.UserDTO;
import com.zpx.purchasingsystem.repositories.UserRepository;
import com.zpx.purchasingsystem.services.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        obj.orElseThrow(() -> new RuntimeException("nao encontrado"));
        return obj;
    }


    @Override
    @Transactional
    public User createUser(UserDTO client) {
        return userRepository.save(mapper.map(client,User.class));
    }

    @Override
    @Transactional
    public void updateUser(UserDTO client) {
       userRepository.save(mapper.map(client,User.class));

    }


}
