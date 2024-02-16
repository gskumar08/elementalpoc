package org.example.microservice1.feignClient;

import org.example.microservice1.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="userClient", url="http://localhost:9090/")
public interface UserFeignClient {
    @GetMapping("m2/user")
    public User getUser();
}
