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

    public String testPage(Model model) {
        SensorObservation sensorObservation = sensorObservationRepository.findById(2082).get();
        List<SensorObservation> sensorObservationList = (List<SensorObservation>) sensorObservationRepository.findAll();
        model.addAttribute(sensorObservation);
        model.addAttribute(sensorObservationList);

        return "sensordata";
    }

}
