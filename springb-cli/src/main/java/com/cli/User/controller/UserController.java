package com.cli.User.controller;

import com.cli.User.inter.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description //TODO
 *
 * @Author honva
 * @Date 2020/7/5
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInterface userInterface;

    @RequestMapping("/getUsers")
    public String getUsers(){
        System.out.println(">>> cli service in....");
        String result = userInterface.getUsers("tom");
        return result;
    }
}
