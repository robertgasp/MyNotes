package com.example.mynotes.domain;

import com.example.mynotes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    public List<Notes> getNotes() {
        ArrayList<Notes> notes = new ArrayList<>();
        notes.add(new Notes(R.string.note1,R.string.note_content_1));
        notes.add(new Notes(R.string.note2,R.string.note_content_2));
        return notes;
    }
}
