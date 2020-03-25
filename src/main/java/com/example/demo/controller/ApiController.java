package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.sensehat.SensorObservation;
import com.example.demo.sensehat.SensorObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


 /*   @Autowired
>>>>>>> b6c54fcde818883cc7c5595b549075d06be85ea2
    SensorObservationRepository sensorObservationRepository;

    @Autowired
    NavigationApi navigationApi;

/*    @GetMapping("/api/sensor-observation")
    public SensorObservation currentObservation() {
        return sensorObservationRepository.findById(1L).get();

    }*/

    @PostMapping(path = "/api/navigation", consumes = "application/json", produces = "application/json")
    public void navigate(@RequestBody Navigation navigation) {
        //navigationApi.navigationState(navigation.getDirection());
        System.out.println(navigation.toString());
    }

}
