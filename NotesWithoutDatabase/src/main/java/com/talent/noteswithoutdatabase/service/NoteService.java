package com.talent.noteswithoutdatabase.service;

import com.talent.noteswithoutdatabase.model.Note;
import com.talent.noteswithoutdatabase.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NotesRepository notesRepository;

    @Autowired
    public NoteService(NotesRepository notesRepository) {

        this.notesRepository = notesRepository;
    }

    public void createNote(String title, String content) {
        Note note = new Note(title, content);
        notesRepository.saveNote(note);
    }

    public List<Note> findNotes() {

        return notesRepository.findAll();
    }

    public Optional<Note> findNote(Long id) {

        return notesRepository.findById(id);
    }

    public void deleteNote(Long id){
        notesRepository.deleteNote(id);
    }

    public Optional<Note> updateNote(Long id, Note note) {
        return notesRepository.updateNote(id, note);
    }
}
