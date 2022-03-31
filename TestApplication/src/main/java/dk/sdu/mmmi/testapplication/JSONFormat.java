package dk.sdu.mmmi.testapplication;

public class JSONFormat {
    //JSON format
    private long measurementTimeMs;
    private String sensorId;
    private double value;
    private String unit;

    public JSONFormat(long measurementTimeMs, String sensorId, double value, String unit) {
        this.measurementTimeMs = measurementTimeMs;
        this.sensorId = sensorId;
        this.value = value;
        this.unit = unit;
    }

    public JSONFormat(){

    }

    public long getMeasurementTimeMs() {
        return measurementTimeMs;
    }

    public void setMeasurementTimeMs(long measurementTimeMs) {
        this.measurementTimeMs = measurementTimeMs;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

