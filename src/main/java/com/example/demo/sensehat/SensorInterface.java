package com.example.demo.sensehat;

public interface SensorInterface {
    double getPressure();
    double getHumidity();
    double getTemperatureFromPressure();
    double getTemperatureFromHumidity();


}
