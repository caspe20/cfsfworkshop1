package dk.sdu.mmmi.testapplication;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

public class TopicPublisher {

    private static final String HAZELCAST_HOST = "10.112.254.14";
    private static final int HAZELCAST_PORT = 5701;
    ITopic<String> topic;

    public void publish(String topic, String message) {
        HazelcastInstance hz = getHazelcastInstance();
        this.topic = hz.getTopic(topic);
        this.topic.publish(message);
        hz.shutdown();
    }

    private static HazelcastInstance getHazelcastInstance(){
        String hazelcastAddress = String.format("%s:%d", HAZELCAST_HOST, HAZELCAST_PORT);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hazelcastAddress);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }

}