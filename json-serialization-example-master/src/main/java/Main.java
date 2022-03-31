import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        long timeMs = System.currentTimeMillis();
        String sender = "Flemming Henning";
        String content = "Hi, Flemming Henning is here.";
        Message message = new Message(timeMs, sender, content);

        String json = mapper.writeValueAsString(message);

        Message deserializedMessage = mapper.readValue(json, Message.class);
    }
}
