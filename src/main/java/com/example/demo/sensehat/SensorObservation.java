package com.example.demo.sensehat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SensorObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime timestamp;
    private Double temperature;
    private Double humidity;
    private Double pressure;

    public SensorObservation(){
    }

/*    public SensorObservation(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        this.timestamp = LocalDateTime.now();
        this.temperature = senseHatMethods.getTemperature();
        this.humidity = senseHatMethods.getHumidity();
        this.pressure = senseHatMethods.getPressure();
    }*/

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
}
