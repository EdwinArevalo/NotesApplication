package com.arevalo.notesapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.arevalo.notesapplication.R;
import com.arevalo.notesapplication.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private EditText inputUser;
    private EditText inputPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUser = findViewById(R.id.inputUserLogin);
        inputPass = findViewById(R.id.inputPasswordLogin);
    }

    public void callDoRegister(View view) {

        Intent intent = new Intent(this,RegisterActivity.class);
        startActivityForResult(intent,REGISTER_FORM_REQUEST);
    }


    public void callLogin(View view) {
        String user = inputUser.getText().toString();
        String pass = inputPass.getText().toString();

        if( user.isEmpty()  || pass.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        List<User> users = SugarRecord.listAll(User.class);
        Intent intent;
        for (User u: users){
            if (u.getName().equals(user) || u.getPassword().equals(pass)){
                intent = new Intent(this,IndexActivity.class);
                Toast.makeText(this,"Iniciando Sesion",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
    }
}
