package edu.ucalgary.ensf409;

import java.io.Serializable;

public class TranslationText implements Serializable {
    static final long serialVersionUID = 19L;
    private String[] months;
    private String[] days;
    private String sentence;

    public TranslationText(String[] months, String[] days, String sentence) {
        this.months = months;
        this.days = days;
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }

    public String[] getMonths() {
        return this.months;
    }

    public String[] getDays() {
        return this.days;
    }

    public String getDay(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > 30) {
            throw new IndexOutOfBoundsException();
        }
        return months[index];
    }

    public String getMonth(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > 11) {
            throw new IndexOutOfBoundsException();
        }
        return days[index];
    }
}
