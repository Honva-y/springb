package com.cli.User.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "springboot-user")
@Component
public interface UserInterface {

    @RequestMapping(value = "/user/getUsers",method = RequestMethod.GET)
    String getUsers();
}
