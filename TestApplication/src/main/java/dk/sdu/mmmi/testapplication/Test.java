package dk.sdu.mmmi.testapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.mmmi.testapplication.Sensor.CO2SensorAdapter;

/**
 * @author Anders
 */
public class Test {

    public static void main(String[] args) throws JsonProcessingException, InterruptedException {
        //CO2Sensor s = new CO2Sensor("CO2 Sensor");
        //TemperatureSensor t = new TemperatureSensor();
        //
        //s.start();
        //t.start();
        //
        //for (int i = 0; i < 5; i++) {
        //    try {
        //        Thread.sleep(1000);
        //    } catch (InterruptedException ex) {
        //        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        //    }
        //    System.out.println(s.getValue());
        //    System.out.println(t.value());
        //}
        //
        //s.stop();
        //t.stop();
        dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor co2 = new dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor("CO2_432");
        co2.start();
        ObjectMapper mapper = new ObjectMapper();
        long timeMs = System.currentTimeMillis();
        String sensorId = co2.getId();
        double value = co2.getValue();
        String unit = "PPM";
        CO2SensorAdapter JSONMessage = new CO2SensorAdapter(timeMs,sensorId,value,unit);
        String json = mapper.writeValueAsString(JSONMessage);
        System.out.println(json);
        co2.stop();
        

    }
}
