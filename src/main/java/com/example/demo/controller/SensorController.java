package com.example.demo.controller;

import com.example.demo.TempUser;
import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.UserValidator;
import com.example.demo.exceptions.SameUserNameException;
import com.example.demo.exceptions.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SensorController {

    @GetMapping("/sensordata")
    public String SensorDataPage(@ModelAttribute User user) {
        return "sensordata";
    }

}
