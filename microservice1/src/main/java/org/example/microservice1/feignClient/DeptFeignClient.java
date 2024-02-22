package org.example.microservice1.feignClient;

import org.example.microservice1.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="deptClient", url="http://localhost:8585/m3")
public interface DeptFeignClient {
    @GetMapping("/dept")
    public Department getDept();
    @PostMapping("/registerDept")
    public ResponseEntity<Department> saveDept(@RequestBody Department dept);
    @GetMapping("/departments")
    public List<Department> getDepts ();
    @PatchMapping("/department")
    public ResponseEntity<Department> updateDept(@RequestBody Department dept);
    @DeleteMapping("/department/{depId}")
    public ResponseEntity<Void> deleteDept(@PathVariable String depId);
}
