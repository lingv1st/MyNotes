package my.notes.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        makeToast("MainActivity - onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            initView();
        }
    }

    private void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_list_container, NoteListFragment.newInstance())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO Возможно нужно вызвать NoteListFragment.newInstance()? или initView()?
        Fragment backStackFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.note_list_container);
        if (backStackFragment != null && backStackFragment instanceof NoteFragment) {
            onBackPressed();
        }
    }

    static void makeToast(String message) {
        Log.d(TAG, message);
    }
}