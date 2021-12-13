package my.notes.mynotes;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CurrentNoteFragment extends Fragment {

    public static String ARG_NOTE = "note";
    private Note note;

    public static CurrentNoteFragment newInstance(Note note) {
        CurrentNoteFragment fragment = new CurrentNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_note, container, false);
        TextView noteTitle = view.findViewById(R.id.note_title);
        TextView noteDate = view.findViewById(R.id.note_date);
        TextView noteContent = view.findViewById(R.id.note_content);

        String[] noteContents = getResources().getStringArray(R.array.noteContents);
        noteTitle.setText(this.note.getName());
        noteDate.setText(this.note.getFormattedCreationDate());
        noteContent.setText(this.note.getNoteContent());


        return view;
    }
}
