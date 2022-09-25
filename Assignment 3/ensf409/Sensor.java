package edu.ucalgary.ensf409;

import java.util.regex.Pattern;

public class Sensor implements FormattedOutput, Cloneable {
    private String sensor;
    private static String REGEX = "([a-z]+)";
    private static Pattern PATTERN = Pattern.compile(REGEX);

    public Sensor(String sensor) throws IllegalArgumentException {
        if (!sensor.matches(REGEX)) {
            throw new IllegalArgumentException("Robot Sensor is not valid.");
        }
        this.sensor = sensor;
    }

    public String getSensor() {
        return sensor;
    }

    public String getFormatted() {
        String output = "Sensor: " + this.sensor;
        return output;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sensor sensorCopy = (Sensor) super.clone();
        sensorCopy.sensor = sensor;
        return sensorCopy;
    }

}
