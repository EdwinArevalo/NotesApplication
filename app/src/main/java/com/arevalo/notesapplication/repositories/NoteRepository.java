package com.arevalo.notesapplication.repositories;

import com.arevalo.notesapplication.models.Note;
import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static List<Note> listFavorites(){
        List<Note> notesFavorites = null;
        List<Note> notes = list();
        for (Note n: notes) {
            if (n.getEstado() == 1){
                notesFavorites.add(n);
            }
        }
        return notesFavorites;
    }

    public static List<Note> listArchived(){
        List<Note> notesArchiveds = null;
        List<Note> notes = list();
        for (Note n: notes) {
            if (n.getEstado() == 2){
                notesArchiveds.add(n);
            }
        }
        return notesArchiveds;
    }

    public static void create(String title,String description, long usuarioId){
        Note note = new Note(title,description,usuarioId);
        SugarRecord.save(note);
    }
}
