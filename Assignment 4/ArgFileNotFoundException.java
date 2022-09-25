package edu.ucalgary.ensf409;

public class ArgFileNotFoundException extends Exception {
    public ArgFileNotFoundException() {
        super("Error: File from command-line argument cannot be found");
    }
}