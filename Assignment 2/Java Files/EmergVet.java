package edu.ucalgary.ensf409;

public class EmergVet {
    private String name;
    private String phoneNum;

    public EmergVet(String name, String phoneNumber) {
        this.name = name;
        this.phoneNum = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
}
