/*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsNull;

public class ExistingFunctionalityTest {
    int expectedTaxRoll = 40381;
    String givenZoning = "residential";
    String expectedZoning = "RESIDENTIAL";
    String expectedStreet = "48th St NW";
    int expectedNumber = 1228;
    String expectedAnnex = "Apt 12";
    String givenPostCode = "T3B1R4";
    String expectedPostCode = "T3B 1R4";

    public HouseholdParking testObject1 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet,
            expectedNumber, givenPostCode, expectedAnnex);
    public HouseholdParking testObject2 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet,
            expectedNumber, givenPostCode);

    /**
     * ****** These tests will become obsolete when the new feature is added
     * ********
     */

    /**
     * ****** These tests will remain relevant when the new feature is added
     * ********
     */
    @Test
    public void testStandardizeLicence() {
        Parking parkingObject = new Parking();
        String givenLicence = "Z.23 4*a6&-";
        String expectedLicence = "Z234A6";
        String actualLicence = parkingObject.standardizeAndValidateLicence(givenLicence);
        assertEquals("Licence is not standardized to just digits and upper-case letters", expectedLicence,
                actualLicence);
    }

    @Test
    public void testValidateGoodLicence() {
        String minLicence = "1";
        String maxLicence = "7654321";
        boolean passed = true;

        try {
            String tmp = Parking.standardizeAndValidateLicence(minLicence);
            tmp = Parking.standardizeAndValidateLicence(maxLicence);
        } catch (Exception e) {
            passed = false;
        }
        assertTrue("Minimum or maximum licence length did not validate", passed);
    }

    @Test
    public void testLicenceException() {
        String badLicence = "12345678";
        boolean passed = false;

        try {
            String tmp = Parking.standardizeAndValidateLicence(badLicence);
        } catch (IllegalArgumentException e) {
            passed = true;
        } catch (Exception e) {
        }

        assertTrue("Invalid licence did not throw IllegalArgumentException", passed);
    }

    @Test
    public void testSixArgumentInheritedConstructorAndPropertyInheritedGetters() {
        int actualTaxRoll = testObject1.getTaxRollNumber();
        int actualNumber = testObject1.getBuildingNumber();
        String actualAnnex = testObject1.getBuildingAnnex();
        String actualStreetName = testObject1.getStreetName();
        boolean testResult = false;
        if (actualTaxRoll == expectedTaxRoll &&
                actualNumber == expectedNumber &&
                actualAnnex.equals(expectedAnnex) &&
                actualStreetName.equals(expectedStreet)) {
            testResult = true;
        }
        assertTrue("Incorrect information stored/returned for tax roll, building number, annex, and/or street name",
                testResult);
    }

    @Test
    public void testFiveArgumentInheritedConstructorAndPropertyInheritedGetters() {
        int actualTaxRoll = testObject2.getTaxRollNumber();
        int actualNumber = testObject2.getBuildingNumber();
        String actualStreetName = testObject2.getStreetName();
        boolean testResult = false;
        if (actualTaxRoll == expectedTaxRoll &&
                actualNumber == expectedNumber &&
                actualStreetName.equals(expectedStreet)) {
            testResult = true;
        }
        assertTrue("Incorrect information stored/returned for tax roll, building number, and/or street name",
                testResult);
    }

    @Test
    public void testPropertyInheritedSetters() {
        var testObject3 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet, expectedNumber,
                givenPostCode);
        var newExpectedStreet = "22nd Ave NW";
        var newExpectedNumber = 10;
        var newExpectedAnnex = "B";
        testObject3.setStreetName(newExpectedStreet);
        testObject3.setBuildingNumber(newExpectedNumber);
        testObject3.setBuildingAnnex(newExpectedAnnex);
        int actualNumber = testObject3.getBuildingNumber();
        String actualAnnex = testObject3.getBuildingAnnex();
        String actualStreetName = testObject3.getStreetName();

        boolean testResult = false;
        if (actualNumber == newExpectedNumber &&
                actualAnnex.equals(newExpectedAnnex) &&
                actualStreetName.equals(newExpectedStreet)) {
            testResult = true;
        }
        assertTrue("Error in setter for tax roll, building number, annex, and/or street name", testResult);
    }

    @Test
    public void testZoningGetterSetter() {
        String actualZoning = testObject1.getZoning();
        assertEquals("Zoning is not set correctly by constructor, or there is an error with the getter", expectedZoning,
                actualZoning);

        var testObject3 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet, expectedNumber,
                givenPostCode);
        var newExpectedZoning = "COMMERCIAL";
        testObject3.setZoning(newExpectedZoning);
        actualZoning = testObject3.getZoning();
        assertEquals("Zoning is not set correctly", newExpectedZoning, actualZoning);
    }

    @Test
    public void testPostCodeGetterSetter() {
        String actualPostCode = testObject1.getPostCode();
        assertEquals("PostCode is not set correctly by constructor, or there is an error with the getter",
                expectedPostCode, actualPostCode);

        var testObject3 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet, expectedNumber,
                givenPostCode);
        var newExpectedPostCode = "A39 7S3";
        testObject3.setPostCode(newExpectedPostCode);
        actualPostCode = testObject3.getPostCode();
        assertEquals("PostCode is not set correctly", newExpectedPostCode, actualPostCode);
    }

    @Test
    public void testZoningException() {
        boolean testResult = false;
        String invalidZoning = "HISTORIC";
        try {
            var testObject3 = new HouseholdParking(expectedTaxRoll, invalidZoning, expectedStreet, expectedNumber,
                    givenPostCode);
        } catch (IllegalArgumentException e) {
            testResult = true;
        } catch (Exception e) {
        }
        assertTrue("Invalid zoning did not throw an IllegalArgumentException with constructor", testResult);

        var testObject3 = new HouseholdParking(expectedTaxRoll, expectedZoning, expectedStreet, expectedNumber,
                givenPostCode);
        try {
            testObject3.setZoning(invalidZoning);
        } catch (IllegalArgumentException e) {
            testResult = true;
        } catch (Exception e) {
        }
        assertTrue("Invalid zoning did not throw an IllegalArgumentException with setter", testResult);
    }

    @Test
    public void testPostCodeException() {
        boolean testResult = false;
        String invalidPostCode = "ABC DEF1";
        try {
            var testObject3 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet, expectedNumber,
                    invalidPostCode, expectedAnnex);
        } catch (IllegalArgumentException e) {
            testResult = true;
        } catch (Exception e) {
        }
        assertTrue("Invalid post code did not throw an IllegalArgumentException with constructor", testResult);

        var testObject3 = new HouseholdParking(expectedTaxRoll, givenZoning, expectedStreet, expectedNumber,
                expectedPostCode, expectedAnnex);
        try {
            testObject3.setPostCode(invalidPostCode);
        } catch (IllegalArgumentException e) {
            testResult = true;
        } catch (Exception e) {
        }
        assertTrue("Invalid post code did not throw an IllegalArgumentException with setter", testResult);
    }

    @Test
    public void testHouseholdParkingInheritsFromCalgaryProperty() {
        assertTrue("HouseholdParking does not inherit from CalgaryProperty",
                (testObject1 instanceof CalgaryProperty));
    }

    @Test
    public void testZoningEnumOrdered() {
        assertThat("ZoningTypes COMMERCIAL doesn't exist", ZoningTypes.COMMERCIAL, IsNull.notNullValue());
        assertEquals("ZoningTypes COMMERCIAL isn't in correct order", ZoningTypes.COMMERCIAL.ordinal(), 0);
        assertThat("ZoningTypes RESIDENTIAL doesn't exist", ZoningTypes.RESIDENTIAL, IsNull.notNullValue());
        assertEquals("ZoningTypes RESIDENTIAL isn't in correct order", ZoningTypes.RESIDENTIAL.ordinal(), 1);
        assertThat("ZoningTypes INDUSTRIAL doesn't exist", ZoningTypes.INDUSTRIAL, IsNull.notNullValue());
        assertEquals("ZoningTypes INDUSTRIAL isn't in correct order", ZoningTypes.INDUSTRIAL.ordinal(), 2);
        assertThat("ZoningTypes AGRICULTURAL doesn't exist", ZoningTypes.AGRICULTURAL, IsNull.notNullValue());
        assertEquals("ZoningTypes AGRICULTURAL isn't in correct order", ZoningTypes.AGRICULTURAL.ordinal(), 3);
        assertThat("ZoningTypes MIXED_USE doesn't exist", ZoningTypes.MIXED_USE, IsNull.notNullValue());
        assertEquals("ZoningTypes MIXED_USE isn't in correct order", ZoningTypes.MIXED_USE.ordinal(), 4);
    }

}
