package my.notes.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

public class NoteListFragment extends Fragment implements Constants {

    Note currentNote;
    boolean isLandScape;

    public static NoteListFragment newInstance() {
        return new NoteListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        String[] noteNames = getResources().getStringArray(R.array.noteNames);
        String[] noteContents = getResources().getStringArray(R.array.noteContents);

        for (int i = 0; i < noteNames.length; i++) {
            String name = noteNames[i];
            AppCompatTextView noteList = new AppCompatTextView(getContext());
            noteList.setText(name);
            noteList.setTextSize(getResources().getDimension(R.dimen.list_text_size));
            linearLayout.addView(noteList);

            String content = noteContents[i];

            int finalI = i;
            noteList.setOnClickListener(getOnClickListener(name, content, finalI, savedInstanceState));
        }

        return view;
    }

    @NonNull
    private View.OnClickListener getOnClickListener(String name, String content, int finalI, Bundle savedInstanceState) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (getArguments() != null) {
//                    currentNote = getArguments().getParcelable(CNOTE);
//                } else {
                    currentNote = new Note(finalI, name, content);
//                }

                isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

                showCurrentNote();
            }
        };
        return onClickListener;
    }

    private void showCurrentNote() {
        if (isLandScape) {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.current_note_container, CurrentNoteFragment.newInstance(currentNote))
                    .commit();
        } else {
            showCurrentNotePort();
        }
    }

    private void showCurrentNotePort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, CurrentNoteFragment.newInstance(currentNote))
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable(CNOTE, currentNote);
    }
}
