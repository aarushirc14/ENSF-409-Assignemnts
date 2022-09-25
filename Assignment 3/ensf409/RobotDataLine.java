package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.*;

public class RobotDataLine implements Cloneable{
    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;
    private static String DATE_REGEX = "([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})";
    private static Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static String ROBOT_REGEX = "([0-9]{3}[A-Z]{1})";
    private static Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    public RobotDataLine(String line) throws IllegalArgumentException{
        this.dataLine = line;
        this.robotID = line.substring(6, line.indexOf("-")-1);
        if(!this.robotID.matches(ROBOT_REGEX)){
            throw new IllegalArgumentException("RobotID is not valid.");
        }
        String dateString = line.substring(line.indexOf("[")+1, line.indexOf("]"));
        if(!dateString.matches(DATE_REGEX)){
            throw new IllegalArgumentException("Date is not valid.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            this.date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Robot Date is invalid.");
        }
        this.movement = new Movement(line.substring(line.indexOf("\"")+1, line.indexOf("(")-1));
        this.sensor = new Sensor(line.substring(line.indexOf("(")+1, line.indexOf(")")));
    }

    public String getRobotID() {
        return robotID;
    }

    public String getDataLine() {
        return dataLine;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Movement getMovement() {
        return movement;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RobotDataLine lineCopy = (RobotDataLine) super.clone();
        lineCopy.dataLine = dataLine;
        lineCopy.robotID = robotID;
        lineCopy.sensor = (Sensor) sensor.clone();
        lineCopy.movement = (Movement) movement.clone();
        lineCopy.date = date;

        return lineCopy;
    }
}
    
