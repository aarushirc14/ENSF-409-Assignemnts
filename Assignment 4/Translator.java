package edu.ucalgary.ensf409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Translator {
    private TranslationText transText;
    private final String LANGCODEREGEX = "^[a-z]{2}-[A-Z]{2}$";
    private String langCode;

    public Translator(String langCode) throws IllegalArgumentException, ArgFileNotFoundException {
        this.langCode = langCode;
        if (!this.langCode.matches(LANGCODEREGEX)) {
            throw new IllegalArgumentException("Error: Language code is not in proper format. "
                    + "It must be in the following example format: en-US");
        }
        importTranslation();
    }

    public void importTranslation() throws ArgFileNotFoundException {
        File file = new File(langCode + ".ser");
        File file1 = new File(langCode + ".txt");
        if (file.exists()) {
            deserialize();
        } else if (file1.exists()) {
            importFromText();
        } else {
            throw new ArgFileNotFoundException();
        }
    }

    public void deserialize() {
        try {
            File file = new File(langCode + ".ser");
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            transText = (TranslationText) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error: Serialized translationtext file not found.");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Serialized translationtext file does not contain a TranslationText object.");
            System.exit(1);
        }
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(langCode + ".ser"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(transText);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: TranslationText Serialized file cannot be created.");
            System.exit(1);
        }
    }

    public void importFromText() throws ArgFileNotFoundException {
        String[] months = new String[12];
        String[] days = new String[31];
        File file = new File(langCode + ".txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            for (int i = 0; i < 12; i++) {
                months[i] = reader.readLine();
            }
            for (int i = 0; i < 31; i++) {
                days[i] = reader.readLine();
            }
            String sentence = reader.readLine();
            reader.close();
            fileReader.close();
            transText = new TranslationText(months, days, sentence);
        } catch (IOException e) {
            System.out.println("Error: Input Text File cannot be found.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String translate(int month, int day, int year) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException(
                    "Error: The day or month to be translated is not a valid number representing a day or month.");
        }
        String dayOut = transText.getDays()[day - 1];
        String monthOut = transText.getMonths()[month - 1];
        String sentence = transText.getSentence();
        String output = String.format(sentence, dayOut, monthOut, year);
        return output;
    }

    public TranslationText getTranslation() {
        return transText;
    }
}