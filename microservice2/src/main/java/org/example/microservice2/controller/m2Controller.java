package org.example.microservice2.controller;

import org.example.microservice2.pojo.User;
import org.example.microservice2.service.UserService;
import org.example.microservice2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m2")
public class m2Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> userInfo(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
}
