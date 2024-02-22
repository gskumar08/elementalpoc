package org.example.microservice1.service;

import org.example.microservice1.pojo.Department;
import org.example.microservice1.pojo.Employee;
import org.example.microservice1.pojo.User;

import java.util.List;

public interface M1Service {
    User getUserdetails();
    Department getDeptdetails();

    List<Employee> getAllEmps();
    List<Department> getAllDepts();
}
