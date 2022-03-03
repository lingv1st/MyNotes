package my.notes.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Note implements Parcelable {

    private int noteIndex;
    private Calendar currentDate = new GregorianCalendar();
    private Calendar creationDate = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Note(int noteIndex) {
        this.noteIndex = noteIndex;
        this.currentDate.setTimeInMillis(System.currentTimeMillis());
        this.creationDate = getCurrentDate();
    }

    protected Note(Parcel in) {
        noteIndex = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getNoteIndex() {
        return noteIndex;
    }

    public void setCreationDate(int year, int monthOfYear, int dayOfMonth) {
        this.creationDate.set(year, monthOfYear, dayOfMonth);
    }

    public String getFormattedCreationDate() {
        return dateFormat.format(creationDate.getTime());
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(noteIndex);
    }
}
