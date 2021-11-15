package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Scab extends AppCompatActivity {
    ImageButton btnScabLeft,btnScabInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scab);

        btnScabLeft = findViewById(R.id.btnScabLeft);
        btnScabLeft.setOnClickListener(v -> {
            Intent intent = new Intent(Scab.this, Rust.class);
            startActivity(intent);
        });

        btnScabInicio = findViewById(R.id.btnScabInicio);
        btnScabInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Scab.this, MainActivity.class);
            startActivity(intent);
        });

    }
}