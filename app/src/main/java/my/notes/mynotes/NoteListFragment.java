package my.notes.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

public class NoteListFragment extends Fragment implements Constants {

    private Note currentNote;
    boolean isLandScape;

    public static NoteListFragment newInstance() {
//        MainActivity.makeToast("NoteListFragment - newInstance()");
        return new NoteListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        MainActivity.makeToast("NoteListFragment - onCreateView");
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        MainActivity.makeToast("NoteListFragment - onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
            currentNote = new Note(0);
        } else {
            currentNote = savedInstanceState.getParcelable(CNOTE);
        }

        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandScape) {
            showCurrentNoteLand();
        }

        initView(view);
    }

    private void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        String[] noteNames = getResources().getStringArray(R.array.noteNames);

        for (int i = 0; i < noteNames.length; i++) {
            String name = noteNames[i];
            AppCompatTextView noteList = new AppCompatTextView(getContext());
            noteList.setText(name);
            noteList.setTextSize(getResources().getDimension(R.dimen.list_text_size));
            linearLayout.addView(noteList);

            int finalI = i;
            noteList.setOnClickListener(getOnClickListener(finalI));
        }
    }

    @NonNull
    private View.OnClickListener getOnClickListener(int finalI) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentNote = new Note(finalI);//, name, content);
                if (isLandScape) {
                    showCurrentNoteLand();
                } else {
                    showCurrentNotePort();
                }
            }
        };
        return onClickListener;
    }

    // Отобразить текущую заметку в ландшафтной ориентации
    private void showCurrentNoteLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.current_note_container, NoteFragment.newInstance(currentNote))
                .commit();
    }

    // Отобразить текущую заметку в портретной ориентации
    private void showCurrentNotePort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteFragment.newInstance(currentNote))
                .addToBackStack("")
                .commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
//        MainActivity.makeToast("NoteListFragment - onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putParcelable(CNOTE, currentNote);
    }
}
