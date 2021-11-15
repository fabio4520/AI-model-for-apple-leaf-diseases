package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class complex extends AppCompatActivity {
    ImageButton btnComplexInicio, btnComplexRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        btnComplexInicio = findViewById(R.id.btnComplexInicio);
        btnComplexInicio.setOnClickListener(v -> {
            Intent intent = new Intent(complex.this, MainActivity.class);
            startActivity(intent);
        });

        btnComplexRight = findViewById(R.id.btnComplexRight);
        btnComplexRight.setOnClickListener(v -> {
            Intent intent = new Intent(complex.this, Frog_eye_leaf_spot.class);
            startActivity(intent);
        });
    }
}