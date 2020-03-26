package com.example.demo.controller;


import com.example.demo.User;
import com.example.demo.UserRepository;
import com.example.demo.sensehat.SensorObservation;
import com.example.demo.sensehat.SensorObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SensorController {
    @Autowired
    private SensorObservationRepository sensorObservationRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/sensordata")
<<<<<<< HEAD
=======

>>>>>>> ad5200fcb24d9ac6b8ae4e32a8bc4ec2568f8c57
    public String testPage(Model model) {
        SensorObservation sensorObservation = sensorObservationRepository.findById(2082).get();
        List<SensorObservation> sensorObservationList = (List<SensorObservation>) sensorObservationRepository.findAll();
        model.addAttribute(sensorObservation);
        model.addAttribute(sensorObservationList);

        return "sensordata";
    }

}
