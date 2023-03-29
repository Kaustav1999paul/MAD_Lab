package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.lab2.Fragments.BlankFragment;
import com.example.lab2.Fragments.BlankFragment2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Lab3 extends AppCompatActivity {

    FloatingActionButton click1, click2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        click1 = findViewById(R.id.click1);
        click2 = findViewById(R.id.click2);

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleFrames(new BlankFragment2());
            }
        });

        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleFrames(new BlankFragment());
            }
        });

    }

    private void handleFrames(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}