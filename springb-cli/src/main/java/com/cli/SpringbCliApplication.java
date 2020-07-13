package com.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author honva
 * @Date 2020/7/5
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.cli.User.inter")
public class SpringbCliApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbCliApplication.class,args);
    }
}
