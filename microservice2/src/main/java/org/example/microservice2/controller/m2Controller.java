package org.example.microservice2.controller;

import org.example.microservice2.entity.Employee;
import org.example.microservice2.pojo.User;
import org.example.microservice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/m2")
public class m2Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> userInfo(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> saveUser(@RequestBody User user){
        System.out.println("Request Payload :"+user);
        return new ResponseEntity<>(userService. save(user), HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees (){
        return userService. findAll();
    }

    @PatchMapping("/employee")
    public ResponseEntity<Employee> updateUser(@RequestBody User user) throws Exception {
        System.out.println("Request Payload :"+user);
        return ResponseEntity.ok().body(userService.updateEmployee(user));
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String empId) throws Exception {
        userService.removeEmployee(empId);
        return ResponseEntity.ok().build();
    }
}
