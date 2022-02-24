package my.notes.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Note implements Parcelable {

    private int noteIndex;
    private String name;
    private String noteContent;
    private Calendar currentDate = new GregorianCalendar();
    private Calendar creationDate = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Note(int noteIndex, String name, String noteContent) {
        this.noteIndex = noteIndex;
        this.name = name;
        this.noteContent = noteContent;
        this.currentDate.setTimeInMillis(System.currentTimeMillis());
        this.creationDate = getCurrentDate();
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

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreationDate(int year, int monthOfYear, int dayOfMonth) {
        this.creationDate.set(year, monthOfYear, dayOfMonth);
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public String getFormattedCreationDate() {
        return dateFormat.format(creationDate.getTime());
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    public String getFormattedCurrentDate() {
        return dateFormat.format(currentDate.getTime());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
