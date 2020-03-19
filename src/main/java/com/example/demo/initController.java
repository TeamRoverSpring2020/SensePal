package com.example.demo;

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
        User user = userRepository.findByUsername("kris");
        if(user==null){
            user = new User();
            user.setUsername("user");
            user.setPassword(encoder.encode("hej"));
            userRepository.save(user);
        }
        return "ok";

    }
}