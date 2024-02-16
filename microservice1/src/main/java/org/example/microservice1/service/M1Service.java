package org.example.microservice1.service;

import org.example.microservice1.pojo.Department;
import org.example.microservice1.pojo.User;

public interface M1Service {
    User getUserdetails();
    Department getDeptdetails();
}
