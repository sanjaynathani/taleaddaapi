package com.taleadda.restapi.controller;

import com.taleadda.restapi.domain.User;
import com.taleadda.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody User userInfo){
        return userRepository.findUserByUsernameAndPassword(userInfo.getUsername(), userInfo.getPassword());
    }

    @PostMapping("/createuser")
    public User addUser(@RequestBody User userInfo){
        return userRepository.insert(userInfo);
    }
}
