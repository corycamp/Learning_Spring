package com.practice.spring_security.service;

import com.practice.spring_security.model.User;
import com.practice.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    public User saveUser(User user){
        System.out.println("Calling repo");
        return repo.save(user);
    }
}
