package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textAbout = findViewById(R.id.textAbout);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String about = extras.getString("about");
            textAbout.setText(about);
        }
    }
}