package org.example.microservice1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
   private Integer id;
   private String name;
   private Integer noOfStudent;
}
