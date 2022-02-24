package my.notes.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Constants {

    Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {

        String[] noteNames = getResources().getStringArray(R.array.noteNames);
        String[] noteContents = getResources().getStringArray(R.array.noteContents);

//        if (savedInstanceState == null) {
            currentNote = new Note(0, noteNames[0], noteContents[0]);
//        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteListFragment.newInstance())
                .commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE && savedInstanceState != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.current_note_container, CurrentNoteFragment.newInstance(currentNote))
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable(CNOTE, currentNote);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

//        if (savedInstanceState != null) {
//            currentNote = savedInstanceState.getParcelable(CNOTE);
//        }
    }
}