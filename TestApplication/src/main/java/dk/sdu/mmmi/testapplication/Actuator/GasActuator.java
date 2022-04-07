package dk.sdu.mmmi.testapplication.Actuator;

import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import org.json.JSONObject;

public class GasActuator extends TopicSubscriber implements IActuator {
    

    @Override
    public void setValue() {

    }

    @Override
    public void getName() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    private static class MessageListenerImpl implements MessageListener<String> {
        public void onMessage(Message<String> m) {
            JSONObject obj = new JSONObject(m.getMessageObject());
        }
    }
}
