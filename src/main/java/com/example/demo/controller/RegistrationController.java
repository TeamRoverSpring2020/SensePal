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
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    TempUser tempUser;

    public RegistrationController(TempUser tempUser) {
        this.tempUser = tempUser;
    }


    @GetMapping("/signup")
    public String signup(Model model, @ModelAttribute User user) {
        model.addAttribute("tempRegisterUser", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@Valid User user, BindingResult result, @RequestParam String password2, Model model) throws SameUserNameException, WrongPasswordException {
        boolean isInDatabase = userRepository.existsUserByUsername(user.getUsername());

        if (isInDatabase) {
            tempUser.addNewUser(user);
            model.addAttribute("user", user);
            throw new SameUserNameException();
        }

        UserValidator userValidator = new UserValidator();
        if (userValidator.supports(user.getClass())) {
            userValidator.validate(user, result);
        }
        if (!user.getPassword().equals(password2)) {
            tempUser.addNewUser(user);
            model.addAttribute("user", user);
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
        model.addAttribute("user", tempUser.getTempararyUser());
        model.addAttribute("invalidUserName", String.format("User %s already exists", tempUser.getTempararyUser().getUsername()));
        tempUser.removeTempararyUser();
        return "signup";
    }

    @ExceptionHandler(WrongPasswordException.class)
    String confirmedPassword(Model model) {
        model.addAttribute("user", tempUser.getTempararyUser());
        model.addAttribute("invalidPassword", "Please enter a valid password - Password doesn't match");
        tempUser.removeTempararyUser();
        return "signup";
    }

}
