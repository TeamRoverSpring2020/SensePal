package com.example.demo.controller;
import com.example.demo.User;
import com.example.demo.sensehat.SensorObservation;
import com.example.demo.sensehat.SensorObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private SensorObservationRepository sensorObservationRepository;

    @GetMapping("/home")
    public String homePage(Model model) {
        SensorObservation sensorObservation = sensorObservationRepository.findById(2082).get();
        List<SensorObservation> sensorObservationList = (List<SensorObservation>) sensorObservationRepository.findAll();
        model.addAttribute(sensorObservation);
        model.addAttribute(sensorObservationList);
        return "home";
    }
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

}
