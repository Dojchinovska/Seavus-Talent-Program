package com.talent.notesJpa.repository;

import com.talent.notesJpa.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note,Long> {

}



