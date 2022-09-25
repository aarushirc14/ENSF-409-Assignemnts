/*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.*;

import edu.ucalgary.ensf409.VisitorParking;

public class HouseholdParking extends CalgaryProperty {
    // Each residental property is allowed one street parking permit
    private LinkedList<String> residentLicence = new LinkedList<String>();
    private int maxLicences = 1;
    private VisitorParking visitors = new VisitorParking();

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode,
            String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber, zoning, streetName, buildingNumber, postCode, buildingAnnex);
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode)
            throws IllegalArgumentException {
        super(taxRollNumber, zoning, streetName, buildingNumber, postCode);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most
     * recent
     * Ignore if the licence is already stored
     * 
     * @param licence - The licence plate to be added
     * 
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta
     * licence
     */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        String licenseV = Parking.standardizeAndValidateLicence(licence);
        if (residentLicence.isEmpty()) {
            this.residentLicence.add(licenseV);
        } else {
            this.residentLicence.set(0, licenseV);
        }
        // int len = residentLicence.size();

        // If licence is already in the list, don't continue
        // for (String val : residentLicence) {
        // if (val.equals(licence)) {
        // return;
        // }
        // }

        // If fewer than three are stored, add to list
        // if (len < maxLicences) {
        // residentLicence.add(licence);

        // If more than three are stored, replace last in list
        // } else {
        // this.residentLicence.set(maxLicences-1, licence);
        // }
    }

    /*
     * Remove all listed licences
     * 
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence() {
        this.residentLicence.set(0, "");
        return true;
    }

    /*
     * Remove a specific listed licence
     * 
     * @param licence - the licence to be removed
     * 
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence(String licence) {
        // Standardize the licence name. If it is invalid, it can't exist so return
        // false.
        try {
            licence = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            return false;
        }

        for (int i = 0; i < this.residentLicence.size(); i++) {
            if (licence.equals(this.residentLicence.get(i))) {
                this.residentLicence.remove(i);
                return true;
            }
        }

        // Couldn't find entry
        return false;
    }

    /*
     * Get all the licences stored for the resident
     * 
     * @return An array containing the resident's licences
     */
    public String getResidentLicence() {
        String result = this.residentLicence.get(0);
        return result;
    }

    public void addVisitorReservation(String license) {
        this.visitors.addVisitorReservation(license);
    }

    public void addVisitorReservation(String license, LocalDate datee) {
        this.visitors.addVisitorReservation(license, datee);
    }

    public VisitorParking getVisitors() {
        return this.visitors;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return this.visitors.getLicencesRegisteredForDate();
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate datee) {
        return this.visitors.getLicencesRegisteredForDate(datee);
    }

    public boolean licenceIsRegisteredForDate(String license) {
        return this.visitors.licenceIsRegisteredForDate(license);
    }

    public boolean licenceIsRegisteredForDate(String license, LocalDate datee) {
        return this.visitors.licenceIsRegisteredForDate(license, datee);
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String license) {
        return this.visitors.getAllDaysLicenceIsRegistered(license);
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String license) {
        return this.visitors.getStartDaysLicenceIsRegistered(license);
    }
}
