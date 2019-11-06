package com.arevalo.notesapplication.repositories;

import com.arevalo.notesapplication.models.Note;
import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static void create(String title,String description, long usuarioId){
        Note note = new Note(title,description,usuarioId);
        SugarRecord.save(note);
    }
}
