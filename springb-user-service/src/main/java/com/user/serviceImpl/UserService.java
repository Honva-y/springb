package com.user.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author honva
 * @Date 2020/7/5
 **/

@RestController
@RequestMapping("user")
public class UserService {

    @RequestMapping("/getUsers/{userName}")
    public ResponseEntity getUser(@PathVariable("userName") String userName){
        System.out.println(">>> user service in...."+userName);
        return new ResponseEntity(userName, HttpStatus.OK);
    }
}
