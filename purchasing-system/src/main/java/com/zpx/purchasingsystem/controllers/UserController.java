package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.User;
import com.zpx.purchasingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUser () {
        return userService.findAllUser();
    }

    @PostMapping
    public User createUser (@RequestBody User client){
        return userService.createUser(client);
    }

}
