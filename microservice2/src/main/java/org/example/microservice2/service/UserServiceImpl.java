package org.example.microservice2.service;

import org.example.microservice2.pojo.Gender;
import org.example.microservice2.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User(10,"Emp1","Accounts", Gender.MALE);
    }
}
