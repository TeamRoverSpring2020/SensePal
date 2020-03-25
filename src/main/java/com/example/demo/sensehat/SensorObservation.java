package com.example.demo.sensehat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SensorObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private static LocalDateTime dateTime;
    private Double temperature;
    private Double humidity;
    private Double pressure;

    public SensorObservation(){
    }

/*    public SensorObservation(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        this.temperature = senseHatMethods.getTemperature();
        this.humidity = senseHatMethods.getHumidity();
        this.pressure = senseHatMethods.getPressure();
    }*/

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }


}
