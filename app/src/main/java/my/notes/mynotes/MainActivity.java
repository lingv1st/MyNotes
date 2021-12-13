package my.notes.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        String[] noteNames = getResources().getStringArray(R.array.noteNames);
        String[] noteContents = getResources().getStringArray(R.array.noteContents);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteListFragment.newInstance())
                .commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.current_note_container, CurrentNoteFragment.newInstance(new Note(0, noteNames[0], noteContents[0])))
                    .commit();
        }
    }
}