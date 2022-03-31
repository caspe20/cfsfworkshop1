package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.testapplication.TopicPublisher;
import dk.sdu.mmmi.testapplication.TopicSubscriber;

import java.util.ArrayList;

public class SensorServer {
    public static void main(String[] args) {
        ArrayList<ISensor> sensors = new ArrayList<>();
        sensors.add(new CO2SensorAdapter("CO2_09","PPM"));

        TopicPublisher publisher = new TopicPublisher();

        while(true) {

            sensors.forEach(e -> {
                publisher.publish("sensor",e.toString());
            });

            try {
                Thread.sleep(5050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
