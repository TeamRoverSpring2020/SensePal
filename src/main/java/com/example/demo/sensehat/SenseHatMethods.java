package com.example.demo.sensehat;

public class SenseHatMethods {

    private final SensorInterface sensorInterface;

    public SenseHatMethods(){
        sensorInterface = new PythonInterface();
    }

    public double getPressure() {
        return sensorInterface.getPressure();
    }

    public double getTemperatureFromPressure() {
        return sensorInterface.getTemperatureFromPressure();
    }

    public double getHumidity() {
        return sensorInterface.getHumidity();
    }

    public double getTemperatureFromHumidity() {
        return sensorInterface.getTemperatureFromHumidity();
    }

    public double getTemperature() {
        return (getTemperatureFromHumidity() + getTemperatureFromHumidity()) / 2;
    }

    public static SensorObservation returnSenseObjekt(){
        SensorObservation sensObj = new SensorObservation();
        return sensObj;
    }
}
