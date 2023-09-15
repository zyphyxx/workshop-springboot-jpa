package com.edgar.webservice.resources;

import com.edgar.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") // caminho do recurso
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){  // end point para acessar o users, retorna resposta
        User user = new User(1L,"Maria","maria@gmail.com","119432547","123456");
        return ResponseEntity.ok().body(user);
    }


}
