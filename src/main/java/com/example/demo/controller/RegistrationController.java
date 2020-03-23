package com.example.demo.controller;

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
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@Valid User user, BindingResult result, @ModelAttribute User users, @RequestParam String password2) throws SameUserNameException, WrongPasswordException {
        boolean isInDatabase = userRepository.existsUserByUsername(user.getUsername());

        if (isInDatabase) {
            throw new SameUserNameException();
        }

        UserValidator userValidator = new UserValidator();
        if (userValidator.supports(users.getClass())) {
            userValidator.validate(users, result);
        }
        if (!user.getPassword().equals(password2)) {
            throw new WrongPasswordException();
        }


        if (result.hasErrors()) {
//            model.addAttribute("error", "Failed!");
            return "signup";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        return "login";
    }

    @ExceptionHandler(SameUserNameException.class)
    String invalidUsername(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("invalidUserName", "User already exists");

        return "signup";
    }

    @ExceptionHandler(WrongPasswordException.class)
    String confirmedPassword(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("invalidPassword", "Password does't match");

        return "signup";
    }

}
