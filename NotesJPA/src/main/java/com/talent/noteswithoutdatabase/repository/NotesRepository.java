package com.talent.noteswithoutdatabase.repository;

import com.talent.noteswithoutdatabase.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note,Long> {

}



