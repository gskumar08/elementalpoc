package org.example.microservice2.service;

import org.example.microservice2.entity.Employee;
import org.example.microservice2.pojo.User;

import java.util.List;

public interface UserService {
    public User getUser();

    Employee save(User user);

    Employee updateEmployee(User user) throws Exception;

    void removeEmployee(String id) throws Exception;

    List<Employee> findAll();
}
