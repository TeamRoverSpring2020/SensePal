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

    //private static LocalDateTime dateTime;
    private static String temp;
    private static String fukt;
    private static String trykk;

    public SensorObservation() {
    }

    /* public SenseObjekt(){
        updateData();
        this.dateTime = LocalDateTime.now();
        this.temp = temp;
        this.fukt = fukt;
        this.trykk = trykk;
    }*/

    public static void updateData(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        temp = String.format("%.01f", senseHatMethods.getTemperature());
        fukt = String.format("%.01f", senseHatMethods.getHumidity());
        trykk = String.format("%.01f", senseHatMethods.getPressure());
    }

    public static String getTemp() {
        return temp;
    }

    public static String getFukt() {
        return fukt;
    }

    public static String getTrykk() {
        return trykk;
    }


}
