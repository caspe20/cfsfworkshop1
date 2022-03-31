package dk.sdu.mmmi.testapplication;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

public class TopicSubscriber {

    private static final String HAZELCAST_HOST = "10.112.254.14";
    private static final int HAZELCAST_PORT = 5701;
    ITopic<String> topic;

    public static void main(String[] args) {
        HazelcastInstance hz = getHazelcastInstance();
        ITopic<String> topic = hz.getTopic("CO2Sensor");
        topic.addMessageListener(new MessageListenerImpl());
        System.out.println("Subscribed");
    }

    public void subscribe(String topic) {
        HazelcastInstance hz = getHazelcastInstance();
        this.topic = hz.getTopic(topic);
        this.topic.addMessageListener(new MessageListenerImpl());
        System.out.println("Subscribed to " + topic);
    };

    private static class MessageListenerImpl implements MessageListener<String> {
        public void onMessage(Message<String> m) {
            System.out.println("Received: " + m.getMessageObject());
        }
    }

    private static HazelcastInstance getHazelcastInstance(){
        String hazelcastAddress = String.format("%s:%d", HAZELCAST_HOST, HAZELCAST_PORT);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hazelcastAddress);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }

}
