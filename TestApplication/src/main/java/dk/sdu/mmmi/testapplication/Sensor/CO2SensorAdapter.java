package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;
import org.json.JSONObject;

import java.util.Date;

public class CO2SensorAdapter implements ISensor {
    //JSON format
    private CO2Sensor sensor;
    private final String sensorId;
    private final String unit;

    public CO2SensorAdapter(String sensorId, String unit) {
        sensor = new CO2Sensor("test");
        sensor.start();
        this.sensorId = sensorId;
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