package org.example.microservice2.service;

import org.example.microservice2.entity.Employee;
import org.example.microservice2.pojo.Gender;
import org.example.microservice2.pojo.User;
import org.example.microservice2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public User getUser() {
        System.out.println("Emp  Details :"+new User(10,"Emp1","Accounts", Gender.MALE));
        return new User(10,"Emp1","Accounts", Gender.MALE);
    }

    @Override
    public Employee save(User user) {
        System.out.println("User Details : "+user);
        return repository.save(new Employee(user.getEno().toString(), user.getName(), user.getDept()));
    }

    @Override
    public Employee updateEmployee(User user) throws Exception {
        Optional<Employee> emp = repository.findById(user.getEno().toString());
        if (emp.isPresent()) {
            System.out.println("Found th employee to update : "+emp.get());
            return repository.save(new Employee(user.getEno().toString(), user.getName(), user.getDept()));
        }
        else
            throw new Exception("Unable to find the User");
    }

    @Override
    public void removeEmployee(String id) throws Exception {
        Optional<Employee> emp = repository.findById(id);
        if (emp.isPresent()) {
            System.out.println("Found th employee to delete: "+emp.get());
            repository.deleteById(id);
        }
        else
            throw new Exception("Unable to find the User");
    }


    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
