package org.example.microservice3.repository;

import org.example.microservice3.pojo.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
