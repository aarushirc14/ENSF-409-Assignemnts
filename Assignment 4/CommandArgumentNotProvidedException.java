package edu.ucalgary.ensf409;

public class CommandArgumentNotProvidedException extends Exception {
    public CommandArgumentNotProvidedException() {
        super("Error: No command-line argument specifying the name of the input file (.txt or .ser format) was provided.");
    }
}
