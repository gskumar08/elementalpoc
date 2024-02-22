package org.example.microservice3.controller;

import org.example.microservice3.pojo.Department;
import org.example.microservice3.pojo.User;
import org.example.microservice3.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/m3")
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping("/dept")
    public ResponseEntity<Department> userInfo(){
        System.out.println("Dept Details :"+new Department("11", "Account", 100));
        return new ResponseEntity<>(new Department("11", "Account", 100), HttpStatus.OK);
    }
    @PostMapping("/registerDept")
    public ResponseEntity<Department> saveUser(@RequestBody Department dept){
        System.out.println("Department Request Payload :"+dept);
        return new ResponseEntity<>(service. saveDept(dept), HttpStatus.CREATED);
    }
    @GetMapping("/departments")
    public List<Department> getEmployees (){
        return service.findAll();
    }

    @PatchMapping("/department")
    public ResponseEntity<Department> updateUser(@RequestBody Department dept) throws Exception {
        System.out.println("Department update request Payload :"+dept);
        return ResponseEntity.ok().body(service.updateDept(dept));
    }

    @DeleteMapping("/department/{depId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String depId) throws Exception {
        service.removeDept(depId);
        return ResponseEntity.ok().build();
    }
}
