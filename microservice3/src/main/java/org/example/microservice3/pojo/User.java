package org.example.microservice3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
private  Integer eno;
private  String name;
private String dept;
private Gender gender;
}
