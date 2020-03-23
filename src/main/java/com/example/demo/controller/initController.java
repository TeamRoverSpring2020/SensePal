package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class initController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/init")
    public String init(){
        User user = userRepository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setUsername("admin");
            user.setPassword(encoder.encode("12345678"));
            userRepository.save(user);
        }
        return "ok";

    }
}
