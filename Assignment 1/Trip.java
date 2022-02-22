/* 

    ENSF 409 Assignment 1 Resubmission
    Last Updated Feb 15th 2022
*/
package edu.ucalgary.ensf409;

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;
    private String[] trip;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String addVandK = value + " " + "(" + key + ")";
        return addVandK;
    }

    // Constructor
    public Trip(String[] array) {
        this.trip = array;
        this.arrival = array[0];
        this.departure = array[1];
        this.city = array[2];
        this.country = array[3];
    }

    public Trip() {

    }

    // Given a date string, return just the year
    public static int getYear(String date) {

        return Integer.parseInt(date.substring(0, 4));
    }

    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {

        return Integer.parseInt(date.substring(5, 7));
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip() {

        return fmtString("Arrival", trip[0]) + ", " + fmtString("Departure", trip[1]) + ", "
                + fmtString("City", trip[2])
                + ", " + fmtString("Country", trip[3]);

    }

    // Getter
    public String getArrival() {
        return arrival;
    }

    // Getter
    public String getDeparture() {
        return departure;
    }

    // Getter
    public String getCity() {
        return city;
    }

    // Getter
    public String getCountry() {
        return country;
    }

    // Setter
    public void setArrival(String date) {
        this.arrival = date;
    }

    // Setter
    public void setDeparture(String date) {
        this.departure = date;
    }

    // Setter
    public void setCity(String city) {
        this.city = city;
    }

    // Setter
    public void setCountry(String country) {
        this.country = country;
    }

}