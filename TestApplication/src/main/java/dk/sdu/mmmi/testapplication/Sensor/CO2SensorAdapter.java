package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;
import org.json.JSONObject;

import java.util.Date;

public class CO2SensorAdapter implements ISensor {
    //JSON format
    private CO2Sensor sensor;
    private final String sensorId;
    private final String unit;
    private String room;

    public static int SID = 0;

    public CO2SensorAdapter(String room, String unit) {
        sensor = new CO2Sensor("test");
        sensor.start();
        CO2SensorAdapter.SID++;
        this.sensorId = room + "Sensor" + CO2SensorAdapter.SID;
        this.room = room;
        this.unit = unit;
    }

    @Override
    public String getName() {
        return sensorId;
    }

    @Override
    public Double getValue() {
        return (double) sensor.getValue();
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject()
                .put("measurementTimeMs", System.currentTimeMillis())
                .put("sensorId",getName())
                .put("value",getValue())
                .put("unit",unit);
        return obj.toString();
    }
}