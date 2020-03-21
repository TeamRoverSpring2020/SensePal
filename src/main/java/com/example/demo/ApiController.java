package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    SensorObservationRepository sensorObservationRepository


    @GetMapping
    public SensorObservation currentObservation() {
        return sensorObservationRepository.findById(1L).get();
    }

    @PostMapping("/api/navigation")
    public void navigate(@RequestBody Navigation navigation){
        System.out.println(navigation.toString());
    }

}
