package com.example.demo.controller;
import com.example.demo.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(@ModelAttribute User user) {
        return "home";
    }
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
