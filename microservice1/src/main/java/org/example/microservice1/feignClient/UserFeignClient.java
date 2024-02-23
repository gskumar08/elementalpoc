package org.example.microservice1.feignClient;

import org.example.microservice1.pojo.Employee;
import org.example.microservice1.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="userClient", url="http://EMPLOYEE-SERVICE/m2")
public interface UserFeignClient {
    @GetMapping("/user")
    public User getUser();
    @PostMapping("/register")
    public ResponseEntity<Employee> saveUser(@RequestBody User user);
    @GetMapping("/employees")
    public List<Employee> getEmployees ();

    @PatchMapping("/employee")
    public ResponseEntity<Employee> updateUser(@RequestBody User user);

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String empId);
}
