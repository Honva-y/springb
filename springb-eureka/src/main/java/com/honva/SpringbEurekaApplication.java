package com.honva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbEurekaApplication.class, args);
    }

}
