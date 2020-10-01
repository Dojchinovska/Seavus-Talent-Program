package com.talent.notesJpa.api;

import com.talent.notesJpa.service.NoteService;
import com.talent.notesJpa.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NotesController {

    private NoteService notesService;

    @Autowired

    public NotesController(NoteService notesService) {

        this.notesService = notesService;
    }

    @PostMapping("/api/notes")
    public void createNote(@RequestBody CreateNoteRequest request) {

        notesService.createNote(request.title, request.content);
    }

    @GetMapping("/api/notes/{id}")
    public Optional<Note> findNote(@PathVariable Long id) {

        return notesService.findNote(id);
    }

    @GetMapping("/api/notes")
    public List<Note> findNotes() {

        return notesService.findNotes();
    }

    @DeleteMapping("/api/notes/{id}")
    public void deleteNote(@PathVariable Long id) {

        notesService.deleteNote(id);
    }

    @PutMapping("/api/notes/{id}")
    public Note updateNote(@PathVariable("id") Long id, @RequestBody Note note) throws Exception {

        return notesService.updateNote(id, note);
    }
}
