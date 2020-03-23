package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    SensorObservationRepository sensorObservationRepository;

    @Autowired
    NavigationRepository navigationRepository;

    @GetMapping("/api/sensor-observation")
    public SensorObservation currentObservation() {
        return sensorObservationRepository.findById(1L).get();
    }

    @PostMapping("/api/navigation")
    public void navigate(@RequestBody Navigation navigation){
        navigationRepository.save(navigation);
        System.out.println("navigate");
    }

}
