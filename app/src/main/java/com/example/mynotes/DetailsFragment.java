package com.example.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynotes.domain.Notes;

public class DetailsFragment extends Fragment {
    private static final String NOTE_KEY ="TITLE_KEY";


    public static DetailsFragment newInstance(Notes note) {
        
        Bundle bundle = new Bundle();
        bundle.putParcelable(NOTE_KEY,note);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detais,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = view.findViewById(R.id.title);
        TextView noteContent = view.findViewById(R.id.note_content);

        Notes note = getArguments().getParcelable(NOTE_KEY);

        title.setText(note.getTitleRes());
        noteContent.setText(note.getContentRes());

    }
}
