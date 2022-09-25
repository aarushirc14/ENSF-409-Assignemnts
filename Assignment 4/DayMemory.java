package edu.ucalgary.ensf409;

public class DayMemory {
    public static void main(String[] args)
            throws CommandArgumentNotProvidedException, IllegalArgumentException, ArgFileNotFoundException {
        if (args.length == 0) {
            throw new CommandArgumentNotProvidedException();
        }
    }
}