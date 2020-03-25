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
        //updateData();
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        this.temperature = senseHatMethods.getTemperature();
        this.humidity = senseHatMethods.getHumidity();
        this.pressure = senseHatMethods.getPressure();
    }

  /*  public void updateData(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        this.temperature = String.format("%.01f", senseHatMethods.getTemperature());
        this.humidity = String.format("%.01f", senseHatMethods.getHumidity());
        this.pressure = String.format("%.01f", senseHatMethods.getPressure());
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
