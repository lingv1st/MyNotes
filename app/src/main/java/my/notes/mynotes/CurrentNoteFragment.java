package my.notes.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class CurrentNoteFragment extends Fragment implements Constants {

//    public static String ARG_NOTE = "NOTE";
    private Note currentNote;
    TextView noteTitle;
    TextView noteDate;
    TextView noteContent;
    DatePicker datePicker;

    public static CurrentNoteFragment newInstance(Note note) {
        CurrentNoteFragment fragment = new CurrentNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CNOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_note, container, false);

        initView(view);

        String[] noteNames = getStrings(view, R.array.noteNames);
        String[] noteContents = getStrings(view, R.array.noteContents);

        currentNote = new Note(0, noteNames[0], noteContents[0]);

        if (getArguments() != null) {
            currentNote = getArguments().getParcelable(CNOTE);
        }

        fillTheNote(currentNote);

        return view;
    }

    private void fillTheNote(Note currentNote) {
        noteTitle.setText(currentNote.getName());
        noteContent.setText(currentNote.getNoteContent());
        noteDate.setText(currentNote.getFormattedCreationDate());

        datePicker.init(2022, 02, 24,
                new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                currentNote.setCreationDate(year, monthOfYear, dayOfMonth);
                noteDate.setText(currentNote.getFormattedCreationDate());
            }
        });
    }

    private String[] getStrings(View view, int p) {
        return view.getResources().getStringArray(p);
    }

    private void initView(View view) {

        noteTitle = view.findViewById(R.id.note_title);
        noteDate = view.findViewById(R.id.note_date);
        noteContent = view.findViewById(R.id.note_content);
        datePicker = view.findViewById(R.id.date_picker);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable(CNOTE, currentNote);
    }
}
