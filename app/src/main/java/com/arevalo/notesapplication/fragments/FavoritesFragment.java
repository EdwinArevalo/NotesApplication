package com.arevalo.notesapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.adapters.NoteAdapter;
import com.arevalo.notesapplication.models.Note;
import com.arevalo.notesapplication.repositories.NoteRepository;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    private RecyclerView notList;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        notList = view.findViewById(R.id.notesList);
        notList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Note> notes = NoteRepository.listFavorites();
        notList.setAdapter(new NoteAdapter(notes));

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NoteAdapter adapter = (NoteAdapter)notList.getAdapter();
        List<Note> notes = NoteRepository.listFavorites();

        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }

}
