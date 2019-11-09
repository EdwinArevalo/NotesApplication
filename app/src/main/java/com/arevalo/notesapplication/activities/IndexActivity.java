package com.arevalo.notesapplication.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.adapters.NoteAdapter;
import com.arevalo.notesapplication.fragments.ArchivedsFragment;
import com.arevalo.notesapplication.fragments.FavoritesFragment;
import com.arevalo.notesapplication.fragments.HomeFragment;
import com.arevalo.notesapplication.models.Note;
import com.arevalo.notesapplication.models.User;
import com.arevalo.notesapplication.repositories.NoteRepository;
import com.arevalo.notesapplication.repositories.UserRepository;

import java.util.List;

public class IndexActivity extends AppCompatActivity {
    private static final int REGISTER_FORM_REQUEST = 100;

    private TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        fullname = findViewById(R.id.textFullname);



        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("user",null);

        User usuario;
        usuario = UserRepository.findByUsername(username);
        if(usuario != null){
            fullname.setText(usuario.getFullname());
        }

        //hacer aparecer por defecto el fragmento inicio
        showHome();
    }

    public void callRegisterForm(View view) {

        Intent intent = new Intent(this,NotesRegisterActivity.class);
        startActivityForResult(intent,REGISTER_FORM_REQUEST);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_home:
                showHome();
                break;

            case R.id.action_favorito:
                showFavorites();
                break;

            case R.id.action_archivados:
                showArchiveds();
                break;

            case R.id.action_close:
                item.setChecked(true);
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                sp.edit().remove("isLogged").commit();
                startActivity(new Intent(this,MainActivity.class));
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showHome(){
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.content, fragment).commit();
    }

    public void showArchiveds(){
        Fragment fragment = new ArchivedsFragment();
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.content, fragment).commit();
    }

    public void showFavorites(){
        Fragment fragment = new FavoritesFragment();
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.content, fragment).commit();
    }
}