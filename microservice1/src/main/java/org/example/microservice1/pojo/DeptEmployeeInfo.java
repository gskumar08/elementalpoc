package org.example.microservice1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptEmployeeInfo {
    List<Employee> emps;
    List<Department> depts;
}
