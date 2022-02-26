
package edu.ucalgary.ensf409;

public class Pet {

    private final String NAME;
    private final String SPECIES;
    private final String BREED;
    private final String COLOUR;
    private boolean vaccineStatus = false;
    private Client owner;
    private EmergVet vet;
    private CareProfile care;

    public Pet(String name, String species, String breed, String colour, Client owner) {
        this.NAME = name;
        this.SPECIES = species;
        this.BREED = breed;
        this.COLOUR = colour;
        this.owner = new Client(owner.getName(), owner.getPhoneNumber(), owner.getAddress());
    }

    public void setVet(EmergVet vet) {
        this.vet = new EmergVet(vet.getName(), vet.getPhoneNum());
    }

    public EmergVet getVet() {
        return vet;
    }

    public void updateVaccineStatus(boolean change) {
        this.vaccineStatus = change;

    }

    public boolean getVaccineStatus() {
        return vaccineStatus;

    }

    public void setCare(String[] meds, String medlnstr, String feedingInstr) {
        this.care = new CareProfile(meds, medlnstr, feedingInstr);
    }

    public String getCareSummary() {
        String caresum = this.care.summarizeCareInstructions();
        return "Care for " + NAME + ":" + "\r\n" + caresum;
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client updateOwner) {
        updateOwner = new Client(owner.getName(), owner.getPhoneNumber(), owner.getAddress());
    }

    public String getName() {
        return this.NAME;
    }

    public String getSpecies() {
        return this.SPECIES;
    }

    public String getBreed() {
        return this.BREED;
    }

    public String getColour() {
        return this.COLOUR;
    }
}
