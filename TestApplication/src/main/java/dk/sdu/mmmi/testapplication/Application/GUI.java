package dk.sdu.mmmi.testapplication.Application;

import dk.sdu.mmmi.testapplication.TopicSubscriber;

public class GUI {

    public static void main(String[] args) {
        TopicSubscriber topicSubscriber = new TopicSubscriber();
        topicSubscriber.subscribe("sensor");
    }
}
