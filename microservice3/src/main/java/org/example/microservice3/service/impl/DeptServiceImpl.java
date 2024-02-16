package org.example.microservice3.service.impl;

import org.example.microservice3.pojo.Department;

import org.example.microservice3.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Department getDeptdetails() {
        return new Department(11, "Account", 100);
    }
}
