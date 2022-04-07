package dk.sdu.mmmi.testapplication.Application;

import dk.sdu.mmmi.testapplication.Actuator.GasActuator;
import dk.sdu.mmmi.testapplication.TopicSubscriber;

public class GUI {

    private String roomIdentifier = "Room_09";

    public static void main(String[] args) {
//        TopicSubscriber topicSubscriber = new TopicSubscriber();
//        topicSubscriber.subscribe("sensor");
        GasActuator actuator = new GasActuator("sensor", "Room_09");
        System.out.println(actuator);
    }
}
