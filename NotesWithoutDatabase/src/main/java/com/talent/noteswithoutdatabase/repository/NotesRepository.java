package com.talent.noteswithoutdatabase.repository;

import com.talent.noteswithoutdatabase.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NotesRepository {

    private static long nextId = 101;

    private ArrayList<Note> notes = new ArrayList<>();

    public void saveNote(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public List<Note> findAll() {

        return notes;
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public Optional<Note> updateNote(Long id, Note note) {

        Optional<Note> n = findById(id);
        n.ifPresent(updatedNote -> {
            updatedNote.setTitle(note.getTitle());
            updatedNote.setContent(note.getContent());
        });

        return n;
    }

    public void deleteNote(Long id) {
        Note n = notes.stream().filter(e -> e.getId().equals(id)).findFirst().get();
        this.notes.remove(n);
    }
}
