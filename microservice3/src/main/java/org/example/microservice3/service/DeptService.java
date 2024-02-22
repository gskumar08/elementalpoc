package org.example.microservice3.service;

import org.example.microservice3.pojo.Department;
import org.example.microservice3.pojo.User;

import java.util.List;

public interface DeptService {
    Department getDeptdetails();
    Department saveDept(Department dept);

    Department updateDept(Department dept) throws Exception;

    void removeDept(String deptId) throws Exception;

    List<Department> findAll();
}
