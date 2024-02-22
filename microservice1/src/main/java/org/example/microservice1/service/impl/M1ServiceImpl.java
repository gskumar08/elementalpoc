package org.example.microservice1.service.impl;

import com.sun.source.tree.TryTree;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.example.microservice1.feignClient.DeptFeignClient;
import org.example.microservice1.feignClient.UserFeignClient;
import org.example.microservice1.pojo.Department;
import org.example.microservice1.pojo.Employee;
import org.example.microservice1.pojo.Gender;
import org.example.microservice1.pojo.User;
import org.example.microservice1.service.M1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class M1ServiceImpl implements M1Service {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DeptFeignClient deptFeignClient;
    public static final String USER_SERVICE = "userService";
    public static final String DEPT_SERVICE = "deptService";

    private int UserServiceAttempt =1;
    private int DeptServiceAttempt =1;

    public static final String USER_BASE_URL = "http://localhost:9090/m2/user";
    public static final String DEPT_BASE_URL = "http://localhost:8585/m3/dept";

    @Override
    @CircuitBreaker(name= USER_SERVICE, fallbackMethod = "getDummyUser")
//    @Retry(name = USER_SERVICE,fallbackMethod = "getDummyUser")
    public User getUserdetails(){
        System.out.println("getUserdetails retry method called "+UserServiceAttempt++ +" times on "+ new Date());
        //Using Rest Template
        // User user = restTemplate.getForObject(USER_BASE_URL,User.class);
        User user = userFeignClient.getUser();
        return user;
    }
    public User getDummyUser(Throwable e){
        System.out.println("getDummyUser retry method called "+UserServiceAttempt++ +" times on "+ new Date());
        return new User(0,"Dummyname","DummyDept", Gender.FEMALE);
    }
    @Override
    @CircuitBreaker(name=DEPT_SERVICE, fallbackMethod = "getDummyDept")
//    @Retry(name = DEPT_SERVICE,fallbackMethod = "getDummyDept")
    public Department getDeptdetails() {
            System.out.println("getDeptdetails retry method called "+DeptServiceAttempt++ +" times on "+ new Date());
            // using Rest template
            // Department dept = restTemplate.getForObject(DEPT_BASE_URL, Department.class);
            // Using Feign Client
            Department dept =  deptFeignClient.getDept();
            return dept;
   }
    public Department getDummyDept(Throwable e){
        System.out.println("getDummyDept retry method called "+DeptServiceAttempt++ +" times on "+ new Date());
        return new Department(0,"DummyDept",0);
    }

    @Override
    public List<Employee> getAllEmps() {
        return userFeignClient.getEmployees();
    }

    @Override
    public List<Department> getAllDepts() {
        return deptFeignClient.getDepts();
    }
}
