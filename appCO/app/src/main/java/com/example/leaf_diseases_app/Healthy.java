package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Healthy extends AppCompatActivity {
    ImageButton btnHealthyLeft,btnHealthyInicio,btnHealthyRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);

        btnHealthyLeft = findViewById(R.id.btnHealthyLeft);
        btnHealthyLeft.setOnClickListener(v -> {
            Intent intent = new Intent(Healthy.this, Frog_eye_leaf_spot.class);
            startActivity(intent);
        });

        btnHealthyInicio = findViewById(R.id.btnHealthyInicio);
        btnHealthyInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Healthy.this, MainActivity.class);
            startActivity(intent);
        });

        btnHealthyRight = findViewById(R.id.btnHealthyRight);
        btnHealthyRight.setOnClickListener(v -> {
            Intent intent = new Intent(Healthy.this, Powdery_mildew.class);
            startActivity(intent);
        });

    }
}