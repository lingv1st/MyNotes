package my.notes.mynotes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Note {

    String name;
    String text;
    Calendar creationDate = new GregorianCalendar();

    public Note(String name, String text, Calendar creationDate) {
        this.name = name;
        this.text = text;
        this.creationDate.setTimeInMillis(System.currentTimeMillis());
    }
}
