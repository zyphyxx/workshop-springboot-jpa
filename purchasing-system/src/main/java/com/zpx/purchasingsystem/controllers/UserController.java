package com.zpx.purchasingsystem.controllers;

import com.zpx.purchasingsystem.entities.User;
import com.zpx.purchasingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUser () {
        List<User> obj = userService.findAllUser();
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById (@PathVariable Long id) {
        Optional<User> obj = userService.findUserById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User client){
        User newObj = userService.createUser(client);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

}
