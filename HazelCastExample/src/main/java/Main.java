import java.util.Collection;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.multimap.MultiMap;

public class Main {

    private static final String HAZELCAST_HOST = "127.0.0.1";
    private static final int HAZELCAST_PORT = 5701;

    private static final String MAP_NAME = "my-service-registry";
    private static final String SERVICE = "CO2";
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        HazelcastInstance hz = getHazelcastInstance();
        MultiMap<String,String> map = hz.getMultiMap(MAP_NAME);

        Service service1 = new Service(SERVICE, IP, 8001);
        registerService(map, service1);
        
        Service service2 = new Service(SERVICE, IP, 8002);
        registerService(map, service2);

        queryService(map).forEach(System.out::println);

        hz.shutdown();
    }

    private static HazelcastInstance getHazelcastInstance(){
        String hazelcastAddress = String.format("%s:%d", HAZELCAST_HOST, HAZELCAST_PORT);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(hazelcastAddress);
        return HazelcastClient.newHazelcastClient(clientConfig);
    } 

    private static void registerService(MultiMap<String,String> map, Service service){
        String endpoint = String.format("%s:%d", service.ip, service.port);
        map.put(service.name, endpoint);
    }

    private static Collection<String> queryService(MultiMap<String,String> map){
        Collection<String> servicesEndpoints = map.get(SERVICE);
        return servicesEndpoints;
    }

    /**
     * Service represents the type of service and its specific IP and port.
     */
    public record Service(String name, String ip, int port) {}
}