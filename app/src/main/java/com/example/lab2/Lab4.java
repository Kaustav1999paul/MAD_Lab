package com.example.lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Lab4 extends AppCompatActivity {
    Button click;
    ProgressBar loading;
    TextView text;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        click = findViewById(R.id.click);
        loading = findViewById(R.id.progressBar);
        text = findViewById(R.id.text);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab4.this);
        builder.setMessage("Are you sure u want to continue?");
        builder.setTitle("Alert");
        builder.setIcon(R.mipmap.ic_launcher_round);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                st();
                dialogInterface.cancel();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Lab4.this, "Clicked No", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });

        builder.create().show();
    }


    private void st(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText(String.valueOf(progressStatus));
                        }
                    });

                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}