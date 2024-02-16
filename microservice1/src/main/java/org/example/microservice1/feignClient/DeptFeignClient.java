package org.example.microservice1.feignClient;

import org.example.microservice1.pojo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="deptClient", url="http://localhost:8585")
public interface DeptFeignClient {
    @GetMapping("/m3/dept")
    public Department getDept();
}
