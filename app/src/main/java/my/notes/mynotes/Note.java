package my.notes.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Note implements Parcelable {

    static private int noteIndex;
    private String name;
    private String noteContent;
    private Calendar creationDate = new GregorianCalendar();

    public Note(String name, String noteContent) {
        this.name = name;
        this.noteContent = noteContent;
        this.creationDate.setTimeInMillis(System.currentTimeMillis());
    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public String getFormattedCreationDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(creationDate.getTime());
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
