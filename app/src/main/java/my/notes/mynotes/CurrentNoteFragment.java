package my.notes.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CurrentNoteFragment extends Fragment {

    public static CurrentNoteFragment newInstance() {
        return new CurrentNoteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_note, container, false);
        return view;
    }
}
