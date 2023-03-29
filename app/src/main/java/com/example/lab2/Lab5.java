package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab5 extends AppCompatActivity {

    DBHandler db = new DBHandler(this, "login", null, 1);
    EditText u_edit_text;
    EditText p_edit_text;
    Button button,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        u_edit_text = findViewById(R.id.uname);
        p_edit_text = findViewById(R.id.pass);
        button = findViewById(R.id.submit_button);
        register = findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.search(u_edit_text.getText().toString(),p_edit_text.getText().toString())){
                    Toast.makeText(getApplicationContext(),"username - "+u_edit_text.getText().toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Login Failure",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            db.insert(u_edit_text.getText().toString(), p_edit_text.getText().toString());
                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}