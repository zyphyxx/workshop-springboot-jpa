package com.zpx.purchasingsystem.resources;

import com.zpx.purchasingsystem.domains.dto.UserDTO;
import com.zpx.purchasingsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResources {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    private static final String ID = "/{id}";

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUser() {
        return ResponseEntity.ok().body(userService.findAllUser()
                .stream()
                .map(objs -> mapper.map(objs, UserDTO.class))
                .toList());
    }

    @GetMapping(value = ID)
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.map(userService.findUserById(id), UserDTO.class));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO client) {

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(ID)
                .buildAndExpand(userService.createUser(client).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO client, @PathVariable Long id) {
        client.setId(id);
        userService.updateUser(client);
        return ResponseEntity.noContent().build();
    }

}
