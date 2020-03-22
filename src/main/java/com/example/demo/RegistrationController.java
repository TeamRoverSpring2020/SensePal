package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup( @Valid User user, BindingResult result){
        UserValidator userValidator = new UserValidator();

        if(result.hasErrors()){
//            model.addAttribute("error", "Failed!");
            return "signup";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        return "login";
    }





/*    @PostMapping("/signup")
    public String postSignup( Model model, BindingResult result, @Valid User user){
        UserValidator userValidator = new UserValidator();
        if(userValidator.supports(user.getClass())) {
            userValidator.validate(user, result);
        }
        if(result.hasErrors()){
//            model.addAttribute("error", "Failed!");
            return "signup";
        }


        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        return "login";
    }*/
}

