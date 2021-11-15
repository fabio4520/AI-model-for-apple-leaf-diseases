package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Rust extends AppCompatActivity {
    ImageButton btnRustLeft,btnRustInicio,btnRustRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rust);

        btnRustLeft = findViewById(R.id.btnRustLeft);
        btnRustLeft.setOnClickListener(v -> {
            Intent intent = new Intent(Rust.this, Powdery_mildew.class);
            startActivity(intent);
        });

        btnRustInicio = findViewById(R.id.btnRustInicio);
        btnRustInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Rust.this, MainActivity.class);
            startActivity(intent);
        });

        btnRustRight = findViewById(R.id.btnRustRight);
        btnRustRight.setOnClickListener(v -> {
            Intent intent = new Intent(Rust.this, Scab.class);
            startActivity(intent);
        });

    }
}