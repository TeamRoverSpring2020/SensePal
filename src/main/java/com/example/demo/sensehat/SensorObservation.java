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
    private String temperature;
    private String humidity;
    private String pressure;

    public SensorObservation(){
        //updateData();
    }

    public void updateData(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        this.temperature = String.format("%.01f", senseHatMethods.getTemperature());
        this.humidity = String.format("%.01f", senseHatMethods.getHumidity());
        this.pressure = String.format("%.01f", senseHatMethods.getPressure());
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }


}
