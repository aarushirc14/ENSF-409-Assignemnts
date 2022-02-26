package edu.ucalgary.ensf409;

public class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsInfo = new RewardsProfile();

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public boolean enrollRewards(String newNumber) {

        try {
            this.rewardsInfo = new RewardsProfile(newNumber);
        }

        catch (InvalidRewardsNumException e) {
            return false;
        }
        return true;
    }

    public int getRewardsPoints() {
        int rewardsPoints = rewardsInfo.getPoints();
        return rewardsPoints;

    }

    public void updatePoints(int addPoints) {
        rewardsInfo.setPoints(addPoints);
    }

    public String getRewardsNumber() {

        return this.rewardsInfo.getNumber();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {

        return this.phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
