package com.example.demo.controller;


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


    @GetMapping("/sensordata")
<<<<<<< HEAD
    public String SensorDataPage(@ModelAttribute User user) {
=======
    public String testPage(Model model) {
        SensorObservation sensorObservation = sensorObservationRepository.findById(2082).get();
        List<SensorObservation> sensorObservationList = (List<SensorObservation>) sensorObservationRepository.findAll();
        model.addAttribute(sensorObservation);
        model.addAttribute(sensorObservationList);
>>>>>>> 38ac7c79a5edc5ffc6732ca44d4c658c02f9fc5f
        return "sensordata";
    }

}
