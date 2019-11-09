package com.arevalo.notesapplication.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.models.User;
import com.arevalo.notesapplication.repositories.NoteRepository;
import com.arevalo.notesapplication.repositories.UserRepository;

public class NotesRegisterActivity extends AppCompatActivity {

    private EditText inputTit;
    private EditText inputDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_register);

        inputTit = findViewById(R.id.inputTitle);
        inputDes = findViewById(R.id.inputDescription);


    }

    public void callRegisterNote(View view) {
        String title = inputTit.getText().toString();
        String descrip = inputDes.getText().toString();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("user",null);

        User usuario;
        usuario = UserRepository.findByUsername(username);

        if( title.isEmpty() || descrip.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        NoteRepository.create(title,descrip,usuario.getId());
        finish();
    }
}
