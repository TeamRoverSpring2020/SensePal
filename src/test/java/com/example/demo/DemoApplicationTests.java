package com.example.demo;

import com.example.demo.sensehat.SensorObservation;
import com.example.demo.sensehat.SensorObservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SensorObservationRepository sensorObservationRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldFindUsernameByID() {
        User user = userRepository.findById(1).get();

        Assertions.assertEquals("Admin", user.getUsername());
    }

    @Test
    public void isUserNameInTheDatabase(){
        Assertions.assertTrue(userRepository.existsUserByUsername("Krister"));
        Assertions.assertFalse(userRepository.existsUserByUsername("hej"));
    }


    @Test
    public void isEmailInTheDatabase(){
        Assertions.assertTrue(userRepository.existsByEmail("krister.andersson@medisin.uio.no"));
        Assertions.assertFalse(userRepository.existsUserByUsername("hej"));
    }

    @Test
    public void getSensorValueFromDatabase(){
        SensorObservation sensorObservation = sensorObservationRepository.findById(2082).get();
        System.out.println(sensorObservation.getTemperature());


    }
    @Test
    public void getAllTempratureDataFromDatabase(){
        List<SensorObservation> sensorObservation = (List<SensorObservation>) sensorObservationRepository.findAll();
        for (SensorObservation item : sensorObservation) {
            System.out.println(item.getTemperature());
            System.out.println(item.getId());
            System.out.println(item.getTimestamp());
        }




    }

}
