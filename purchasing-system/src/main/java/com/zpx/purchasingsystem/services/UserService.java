package com.zpx.purchasingsystem.services;

import com.zpx.purchasingsystem.domains.User;
import com.zpx.purchasingsystem.domains.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public List<User> findAllUser();

    public Optional<User> findUserById (Long id);

    public User createUser(UserDTO client);

    public void updateUser (UserDTO client);
}
