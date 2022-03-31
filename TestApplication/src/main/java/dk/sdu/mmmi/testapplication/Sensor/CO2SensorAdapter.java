package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;

import java.util.Date;

public class CO2SensorAdapter implements ISensor {
    //JSON format
    private CO2Sensor sensor;
    private long measurementTimeMs;
    private final String sensorId;
    private double value;
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
        double val = sensor.getValue();
        return val;
    }

    @Override
    public String toString() {
        return "JSONFormat{" +
                "measurementTimeMs=" + System.currentTimeMillis() +
                ", sensorId='" + getName() + '\'' +
                ", value=" + getValue() +
                ", unit='" + unit + '\'' +
                '}';
    }
}