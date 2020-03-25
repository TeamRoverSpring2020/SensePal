package com.example.demo;

import com.pi4j.io.gpio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class NavigationApi {

    final GpioController gpio;

    final GpioPinDigitalOutput pin_00;
    final GpioPinDigitalOutput pin_01;
    final GpioPinDigitalOutput pin_02;
    final GpioPinDigitalOutput pin_03;

    public NavigationApi() {
        this.gpio = GpioFactory.getInstance();
        this.pin_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.LOW);
        this.pin_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        this.pin_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);
        this.pin_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW);
    }

    public void navigationState(String direction) {
        switch (direction) {
            case "right":
                pin_00.high();
                pin_01.low();
                pin_02.high();
                pin_03.low();
                break;
            case "left":
                pin_00.low();
                pin_01.high();
                pin_02.low();
                pin_03.high();
                break;
            case "reverse":
                pin_00.high();
                pin_01.low();
                pin_02.low();
                pin_03.high();
                break;
            case "drive":
                pin_00.low();
                pin_01.high();
                pin_02.high();
                pin_03.low();
                break;
            default:
                pin_00.low();
                pin_01.low();
                pin_02.low();
                pin_03.low();
        }
    }
}
