package org.example.microservice3.controller;

import org.example.microservice3.pojo.Department;
import org.example.microservice3.pojo.User;
import org.example.microservice3.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m3")
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping("/dept")
    public ResponseEntity<Department> userInfo(){
        return new ResponseEntity<>(new Department(11, "Account", 100), HttpStatus.OK);
    }
}
