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


    public SensorObservation() {
    }

    /* public SenseObjekt(){
        updateData();
        this.dateTime = LocalDateTime.now();
        this.temp = temp;
        this.fukt = fukt;
        this.trykk = trykk;
    }*/

    public void updateData(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        temperature = String.format("%.01f", senseHatMethods.getTemperature());
        humidity = String.format("%.01f", senseHatMethods.getHumidity());
        pressure = String.format("%.01f", senseHatMethods.getPressure());
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
