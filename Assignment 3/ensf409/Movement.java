package edu.ucalgary.ensf409;

import java.util.regex.Pattern;

public class Movement implements FormattedOutput, Cloneable {
    private String action;
    private String direction;
    private static String REGEX = "([A-Z]+)( - )([A-Z]{1,2})";
    private static Pattern PATTERN = Pattern.compile(REGEX);

    public Movement(String movement) throws IllegalArgumentException {
        if (!movement.matches(REGEX)) {
            throw new IllegalArgumentException("Robot Movement is not valid.");
        }
        this.action = movement.substring(0, movement.indexOf("-") - 1);
        if (!(this.action.equals("FORWARD") || this.action.equals("LEFT") ||
                this.action.equals("REVERSE") || this.action.equals("RIGHT") ||
                this.action.equals("START") || this.action.equals("STOP"))) {
            throw new IllegalArgumentException("Robot Action is not valid.");
        }
        this.direction = movement.substring(movement.indexOf('-') + 2);
        if (!(this.direction.equals("E") || this.direction.equals("N") ||
                this.direction.equals("NE") || this.direction.equals("NW") ||
                this.direction.equals("S") || this.direction.equals("SE") ||
                this.direction.equals("SW") || this.direction.equals("W"))) {
            throw new IllegalArgumentException("Robot Direction is invalid.");
        }
    }

    public String getAction() {
        return action;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String getFormatted() {
        Directions directionOutput = Directions.E;
        if (this.direction.equals("E")) {
            directionOutput = Directions.E;
        } else if (this.direction.equals("N")) {
            directionOutput = Directions.N;
        } else if (this.direction.equals("NE")) {
            directionOutput = Directions.NE;
        } else if (this.direction.equals("NW")) {
            directionOutput = Directions.NW;
        } else if (this.direction.equals("S")) {
            directionOutput = Directions.S;
        } else if (this.direction.equals("SE")) {
            directionOutput = Directions.SE;
        } else if (this.direction.equals("SW")) {
            directionOutput = Directions.SW;
        } else if (this.direction.equals("W")) {
            directionOutput = Directions.W;
        }
        String output = "Action: " + this.action + ", " + "Direction: " + directionOutput.toString();
        return output;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Movement movementCopy = (Movement) super.clone();
        movementCopy.action = action;
        movementCopy.direction = direction;
        return movementCopy;
    }
}
