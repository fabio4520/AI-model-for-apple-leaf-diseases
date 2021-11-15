package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Powdery_mildew extends AppCompatActivity {
    ImageButton btnPMLeft,btnPMInicio,btnPMRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powdery_mildew);

        btnPMLeft = findViewById(R.id.btnPMLeft);
        btnPMLeft.setOnClickListener(v -> {
            Intent intent = new Intent(Powdery_mildew.this, Healthy.class);
            startActivity(intent);
        });

        btnPMInicio = findViewById(R.id.btnPMInicio);
        btnPMInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Powdery_mildew.this, MainActivity.class);
            startActivity(intent);
        });

        btnPMRight = findViewById(R.id.btnPMRight);
        btnPMRight.setOnClickListener(v -> {
            Intent intent = new Intent(Powdery_mildew.this, Rust.class);
            startActivity(intent);
        });

    }
}