package org.example.microservice1.controller;

import org.example.microservice1.pojo.*;
import org.example.microservice1.service.M1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/m1")
public class M1Controller {
    @Autowired
    private M1Service service;

    @GetMapping("/user")
    public ResponseEntity<User> userInfo(){
        return new ResponseEntity<>(service.getUserdetails(), HttpStatus.OK);
    }

    @GetMapping("/dept")
    public ResponseEntity<Department> deptInfo(){
        return new ResponseEntity<>(service.getDeptdetails(), HttpStatus.OK);
    }

    @GetMapping("/allinfo")
    public ResponseEntity<UserData> allInfo(){
        User user = service.getUserdetails();
        Department dept = service.getDeptdetails();
        System.out.println("All information of the Employee and department: "+new UserData(user,dept));
        return new ResponseEntity<>(new UserData(user,dept), HttpStatus.OK);
    }

    @GetMapping("/deptEmp")
    public ResponseEntity<DeptEmployeeInfo> deptEmpInfo(){
        List<Employee> emps = service.getAllEmps();
        List<Department> depts = service.getAllDepts();
        DeptEmployeeInfo allDetails = new DeptEmployeeInfo(emps,depts);
        System.out.println("All information of the Employee and department: "+allDetails);
        return new ResponseEntity<>(allDetails, HttpStatus.OK);
    }

}
