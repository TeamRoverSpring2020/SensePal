package com.example.demo.sensehat;

import com.example.demo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SensorObservationRepository extends CrudRepository<SensorObservation, Integer> {
    //List<SensorObservation> getSensorObservationByTemperature();

}
