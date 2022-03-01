package my.notes.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Constants {

    //Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        makeToast("MainActivity - onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {
//        if (savedInstanceState == null) {
//            MainActivity.makeToast("MainActivity - savedInstanceState == null");
//            String[] noteNames = getResources().getStringArray(R.array.noteNames);
//            String[] noteContents = getResources().getStringArray(R.array.noteContents);
//            currentNote = new Note(0, noteNames[0], noteContents[0]);
//        }
//        else {
//            currentNote = savedInstanceState.getParcelable(CNOTE);
//        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteListFragment.newInstance())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        makeToast("MainActivity - onSaveInstanceState");
        super.onSaveInstanceState(outState);
//        outState.putParcelable(CNOTE, currentNote);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        makeToast("MainActivity - onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);

//        if (savedInstanceState != null) {
//            currentNote = savedInstanceState.getParcelable(CNOTE);
//        }
    }

    static void makeToast(String message) {
        Log.d(TAG, message);
    }
}