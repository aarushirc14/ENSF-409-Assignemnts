package edu.ucalgary.ensf409;

public class RewardsProfile {
    private String rewardsNum = "Not enrolled";
    private int pointsTotal = 10;

    public RewardsProfile() {

    }

    public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
        if (newNumber.matches("[0-9]+") == true && newNumber.length() == 7) {
            this.rewardsNum = newNumber;

        }

        else {
            throw new InvalidRewardsNumException();

        }

    }

    public void setPoints(int addPoints) {
        this.pointsTotal += addPoints;
    }

    public int getPoints() {
        return this.pointsTotal;
    }

    public String getNumber() {
        return this.rewardsNum;
    }

}
