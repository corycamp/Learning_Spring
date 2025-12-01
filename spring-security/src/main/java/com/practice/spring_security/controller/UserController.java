package com.practice.spring_security.controller;

import com.practice.spring_security.model.User;
import com.practice.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user){
        System.out.println("Called");
        return userService.saveUser(user);
    }
}
