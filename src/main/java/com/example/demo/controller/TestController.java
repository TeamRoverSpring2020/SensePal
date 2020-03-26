package com.example.demo.controller;

import com.example.demo.sensehat.SensorObservation;
import com.example.demo.sensehat.SensorObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private SensorObservationRepository sensorObservationRepository;


    @GetMapping("/test")
    public String testPage(Model model) {
        SensorObservation sensorObservation = sensorObservationRepository.findById(1).get();
        List<SensorObservation> sensorObservationList = (List<SensorObservation>) sensorObservationRepository.findAll();
        model.addAttribute(sensorObservation);
        model.addAttribute(sensorObservationList);
        return "test";
    }
}
