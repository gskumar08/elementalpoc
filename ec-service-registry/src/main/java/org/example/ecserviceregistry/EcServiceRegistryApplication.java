package org.example.ecserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcServiceRegistryApplication.class, args);
    }

}
