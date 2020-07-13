package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author honva
 * @Date 2020/7/5
 **/
@SpringBootApplication
@EnableEurekaClient
public class SpringbUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbUserApplication.class,args);
    }
}
