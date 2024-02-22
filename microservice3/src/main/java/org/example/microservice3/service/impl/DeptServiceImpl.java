package org.example.microservice3.service.impl;

import org.example.microservice3.pojo.Department;

import org.example.microservice3.repository.DepartmentRepository;
import org.example.microservice3.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department getDeptdetails() {
        return new Department("11", "Account", 100);
    }

    @Override
    public Department saveDept(Department dept) {
        System.out.println("Department Details : "+dept);
        return repository.save(dept);
    }

    @Override
    public Department updateDept(Department dept) throws Exception {
        Optional<Department> dep = repository.findById(dept.getId().toString());
        if (dep.isPresent()) {
            System.out.println("Found the Dept to update : "+dep.get());
            return repository.save(dept);
        }
        else
            throw new Exception("Unable to find the Department");
    }

    @Override
    public void removeDept(String deptId) throws Exception {
        Optional<Department> dep = repository.findById(deptId);
        if (dep.isPresent()) {
            System.out.println("Found the Department to delete: "+dep.get());
            repository.deleteById(deptId);
        }
        else
            throw new Exception("Unable to find the Department to delete");
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }
}
