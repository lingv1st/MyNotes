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
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteListFragment.newInstance())
                .commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.current_note_container, CurrentNoteFragment.newInstance(new Note("test title", "test content")))
                    .commit();
        }
    }
}