package dk.sdu.mmmi.testapplication.Actuator;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import org.json.JSONObject;

public class GasActuator implements IActuator {

    private static final String HAZELCAST_HOST = "10.112.254.14";
    private static final int HAZELCAST_PORT = 5701;
    ITopic<String> topic;
    private double value;
    private String room;
    private String actuatorId;

    public static int AID = 0;

    public GasActuator(String topic, String room) {
        subscribe(topic, this);
        this.room = room;
        actuatorId = room + "Actuator" + GasActuator.AID;
        GasActuator.AID++;
    }


    @Override
    public void setValue(double sensorValue) {
        //  ((300 + # * 2000)  / 2000 * 100
        value = (sensorValue - 300) / 2000 * 100;
        System.out.println("Actuator changed: " + value + "%");
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getName() {
        return actuatorId;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void subscribe(String topic, GasActuator obj) {
        HazelcastInstance hz = getHazelcastInstance();
        this.topic = hz.getTopic(topic);
        this.topic.addMessageListener(new MessageListenerImpl(obj));
        System.out.println("Subscribed to " + topic);
    };

    private static class MessageListenerImpl implements MessageListener<String> {

        private GasActuator actuator;

        public MessageListenerImpl(GasActuator actuator) {
            this.actuator = actuator;
        }

        public void onMessage(Message<String> m) {
            JSONObject obj = new JSONObject(m.getMessageObject());
            System.out.println(obj);
            if(obj.has("unit") && obj.has("value") && obj.has("sensorId")&& obj.getString("unit").equals("PPM") && obj.getString("sensorId").contains(actuator.getRoom())){
                actuator.setValue(obj.getDouble("value"));
            }
        }

    }
    private static HazelcastInstance getHazelcastInstance(){
        String hazelcastAddress = String.format("%s:%d", HAZELCAST_HOST, HAZELCAST_PORT);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hazelcastAddress);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
