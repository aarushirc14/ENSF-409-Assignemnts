package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{
    private ArrayList<RobotDataLine> log = new ArrayList<RobotDataLine>();

    public RobotDataRecord(String[] array) {
        for (int i = 0; i < array.length; i++) {
            RobotDataLine newEntry = new RobotDataLine(array[i]);
            log.add(newEntry);
        }
    }

    public RobotDataLine getLine(int index) {
        return log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord() {
        return log;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RobotDataRecord recordCopy = (RobotDataRecord) super.clone();
        recordCopy.log = new ArrayList<RobotDataLine>();
        for (RobotDataLine newLine : this.log) {
            recordCopy.log.add((RobotDataLine) newLine.clone());
        }
        return recordCopy;
    }
}
