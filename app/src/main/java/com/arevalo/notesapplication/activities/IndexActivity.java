package com.arevalo.notesapplication.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.adapters.NoteAdapter;
import com.arevalo.notesapplication.models.Note;
import com.arevalo.notesapplication.repositories.NoteRepository;

import java.util.List;

public class IndexActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView notList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        notList = findViewById(R.id.notesList);
        notList.setLayoutManager(new LinearLayoutManager(this));

        List<Note> notes = NoteRepository.list();
        notList.setAdapter(new NoteAdapter(notes));
    }

    public void callRegisterForm(View view) {

        Intent intent = new Intent(this,NotesRegisterActivity.class);
        startActivityForResult(intent,REGISTER_FORM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NoteAdapter adapter = (NoteAdapter)notList.getAdapter();
        List<Note> users = NoteRepository.list();
        adapter.setNotes(users);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent intent;
        switch (id){
            case R.id.action_home:
                Toast.makeText(this, "Regresando al inicio...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_favorito:
                Toast.makeText(this, "...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_archivados:
                item.setChecked(true);
                Toast.makeText(this, "...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_close:
                item.setChecked(true);
                intent = new Intent(this,MainActivity.class);
                Toast.makeText(this, "Cerrando Sesion....", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
