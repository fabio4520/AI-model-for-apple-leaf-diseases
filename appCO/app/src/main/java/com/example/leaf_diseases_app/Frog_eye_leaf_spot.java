package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Frog_eye_leaf_spot extends AppCompatActivity {
    ImageButton btnFelsLeft,btnFelsInicio,btnFelsRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frog_eye_leaf_spot);

        btnFelsLeft = findViewById(R.id.btnFelsLeft);
        btnFelsLeft.setOnClickListener(v -> {
            Intent intent = new Intent(Frog_eye_leaf_spot.this, complex.class);
            startActivity(intent);
        });

        btnFelsInicio = findViewById(R.id.btnFelsInicio);
        btnFelsInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Frog_eye_leaf_spot.this, MainActivity.class);
            startActivity(intent);
        });

        btnFelsRight = findViewById(R.id.btnFelsRight);
        btnFelsRight.setOnClickListener(v -> {
            Intent intent = new Intent(Frog_eye_leaf_spot.this, Healthy.class);
            startActivity(intent);
        });

    }
}