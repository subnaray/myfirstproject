package com.subhi.controller;

import com.subhi.model.User;
import com.subhi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception
    {
        User isExist=userRepository.findByEmail(user.getEmail());
        if (isExist != null) {
           throw new Exception("User is exist with email"+user.getEmail());
        }
        User savedUser =userRepository.save (user);
        return savedUser;
    }

    //public User findByEmail (String email) throws Exception {
    //    User user = userRepository.findByEmail(email);
    //    if (user == null) {
    //        throw new Exception("User not found with email"+email);
    //    }
    //    return user;
    //}
}
