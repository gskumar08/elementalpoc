package org.example.microservice2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.microservice2.pojo.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="employees")
public class Employee {
    @Id
    private  String eno;
    private  String name;
    private String dept;
}
