package com.example.mynotes;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mynotes.domain.Notes;
import com.example.mynotes.domain.NotesRepository;

import org.w3c.dom.Text;

import java.util.List;


public class ListFragment extends Fragment {

    public interface OnNoteClicked{
        void onNoteClicked (Notes note);
    }

    private OnNoteClicked onNoteClicked;


    public ListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNoteClicked){
            onNoteClicked=(OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked=null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Notes> notes = new NotesRepository().getNotes();
        LinearLayout notesList = view.findViewById(R.id.notesList);
        for (Notes note : notes) {
            View noteView = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, notesList, false);

            noteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNotesDetails (note);
                }
            });


            TextView title = noteView.findViewById(R.id.note_name);
            title.setText(note.getTitleRes());

            notesList.addView(noteView);
        }

    }

    private void openNotesDetails(Notes note) {
        if (onNoteClicked != null){
            onNoteClicked.onNoteClicked(note);
        }
    }
}