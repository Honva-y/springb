package com.user;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

/**
 * @Author honva
 * @Date 2020/7/5
 **/
@SpringBootApplication()
@MapperScan("com.user.dao")
@EnableEurekaClient
public class SpringbUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbUserApplication.class,args);
    }
}
