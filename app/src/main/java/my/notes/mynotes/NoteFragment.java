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

public class NoteFragment extends Fragment implements Constants {

    public static String ARG_NOTE = "NOTE";
    private Note note;
    TextView noteTitle;
    TextView noteDate;
    TextView noteContent;
    DatePicker datePicker;

    public static NoteFragment newInstance(Note note) {
        MainActivity.makeToast("NoteFragment - newInstance()");
        NoteFragment fragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.makeToast("NoteFragment - onCreateView");
        return inflater.inflate(R.layout.fragment_current_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MainActivity.makeToast("NoteFragment - onViewCreated");
        super.onViewCreated(view, savedInstanceState);

//        if (getArguments() == null) {
//            note = new Note(0);//, noteNames[0], noteContents[0]);
//        }
//        else {
            note = getArguments().getParcelable(ARG_NOTE);
        if (note != null) {
            MainActivity.makeToast("note index = " + String.valueOf(note.getNoteIndex()));
        }
//        }

        initView(view);
        fillTheNote();
    }

    private void initView(View view) {
        noteTitle = view.findViewById(R.id.note_title);
        noteDate = view.findViewById(R.id.note_date);
        noteContent = view.findViewById(R.id.note_content);
        datePicker = view.findViewById(R.id.date_picker);
    }

    private void fillTheNote() {
        String[] noteNames = getResources().getStringArray(R.array.noteNames);
        String[] noteContents = getResources().getStringArray(R.array.noteContents);
        noteTitle.setText(noteNames[note.getNoteIndex()]);//(currentNote.getName());
        noteContent.setText(noteContents[note.getNoteIndex()]);//(currentNote.getNoteContent());
        noteDate.setText(note.getFormattedCreationDate());

        datePicker.init(2022, 02, 24,
                new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                note.setCreationDate(year, monthOfYear, dayOfMonth);
                noteDate.setText(note.getFormattedCreationDate());
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        MainActivity.makeToast("NoteFragment - onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
