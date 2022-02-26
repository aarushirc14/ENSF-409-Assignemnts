package edu.ucalgary.ensf409;

public class CareProfile {

    private String[] medList;
    private String medInstructions;
    private String feedingInstructions;

    public CareProfile(String[] medList, String meds, String feeding) {
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }

    public String summarizeCareInstructions() {

        String commaSepMedList = String.join(", ", medList);
        return commaSepMedList + "\n" + medInstructions + "\n"
                + feedingInstructions;
    }

}
