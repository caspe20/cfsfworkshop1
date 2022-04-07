package dk.sdu.mmmi.testapplication.Actuator;

public interface IActuator {
    public void setValue(double value);
    public double getValue();
    public String getName();
    public String toString();
}
