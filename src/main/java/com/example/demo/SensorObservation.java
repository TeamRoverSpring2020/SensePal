package com.example.demo;

import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
public class SensorObservation {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int temperature;
    private int gyroscope;
    private int accelerometer;
    private int magnetometer;
    private int pressure;
    private int humidity;

    public SensorObservation() {
    }

    public SensorObservation(int temperature, int gyroscope, int accelerometer, int magnetometer, int pressure, int humidity) {
        this.temperature = temperature;
        this.gyroscope = gyroscope;
        this.accelerometer = accelerometer;
        this.magnetometer = magnetometer;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(int gyroscope) {
        this.gyroscope = gyroscope;
    }

    public int getAccelerometer() {
        return accelerometer;
    }

    public void setAccelerometer(int accelerometer) {
        this.accelerometer = accelerometer;
    }

    public int getMagnetometer() {
        return magnetometer;
    }

    public void setMagnetometer(int magnetometer) {
        this.magnetometer = magnetometer;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

