/* 
    ENSF 409 Assignment 1 Resubmission
    Last Updated Feb 15th 2022
*/
package edu.ucalgary.ensf409;

public class Itinerary {
    private Trip[] trips = new Trip[20];
    private String[][] data;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {

        String addValueAndKey = value + " " + '(' + key + ')';
        return addValueAndKey;
    }

    // // Constructor
    public Itinerary(String[][] myTrips) {
        this.data = myTrips;
        // System.out.print(data[0][0]);

    }

    // Getter
    public Trip[] getTrips() {
        for (int i = 0; i < data.length; i++) {
            Trip trip = new Trip();
            trip.setArrival(data[i][0]);
            trip.setDeparture(data[i][1]);
            trip.setCity(data[i][2]);
            trip.setCountry(data[i][3]);
            trips[i] = trip;
        }
        return trips;
    }

    public String formatByArrival() {

        String output = "";
        String year;
        String previousyear;
        String month;
        String previousmonth;

        for (int i = 0; i < data.length; i++) {
            year = data[i][0].substring(0, 4);
            month = data[i][0].substring(5, 7);

            if (i > 0) {
                previousyear = data[i - 1][0].substring(0, 4);
                previousmonth = data[i - 1][0].substring(5, 7);

                if (!year.equals(previousyear)) {
                    // output += year + " (Year) \r\n";
                    output += fmtString("Year", year) + "\r\n";
                }
                if (!month.equals(previousmonth)) {
                    output += "--" + Integer.parseInt(month) + " (Month)\r\n";
                }

            } else {
                output = year + " (Year)\r\n";
                output += "--" + Integer.parseInt(month) + " (Month)\r\n";

            }
            if (i < data.length - 1) {
                output += "----" + data[i][2] + " (City), " + data[i][3] + " (Country) (Place)\r\n";
            } else {
                output += "----" + data[i][2] + " (City), " + data[i][3] + " (Country) (Place)";
            }

        }

        return output;

    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        String[][][] dateArray = new String[3][12][20];
        int month;
        int year;
        int yearIndex;
        for (int k = 0; k < data.length; k++) {
            // There could be fewer than 20 trips, meaning we might have empty elements
            // is myTrip an empty array element? If empty, return newArray
            if (data == null) {
                return dateArray;

            }

            // Get the month and year of the current myTrip object
            month = Integer.parseInt(data[k][0].substring(5, 7));
            year = Integer.parseInt(data[k][0].substring(0, 4));
            if (year == 2021) {
                yearIndex = 0;
            } else if (year == 2022) {
                yearIndex = 1;
            } else {
                yearIndex = 2;
            }

            // We need to put the first trip for a given year and month at index 0,
            // the second in the same year and month at index 1, etc.
            for (int i = 0; i < data.length; i++) {
                // find the first empty spot in the third level array
                if (dateArray[yearIndex][month - 1][i] == null) {
                    dateArray[yearIndex][month - 1][i] = fmtString("City", data[k][2]) + ", "
                            + fmtString("Country", data[k][3]);
                    break;
                }
            }
        }

        return dateArray;

    }

}
