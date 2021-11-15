package com.example.leaf_diseases_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Diseases extends AppCompatActivity {
    TextView tvComplex,tvFels, tvHealthy, tvPM, tvRust, tvScab;
    ImageButton btnDiseaseInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        //Complex
        tvComplex = findViewById(R.id.tvComplex);
        tvComplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, complex.class);
                startActivity(intent);
            }
        });
        //Fels
        tvFels = findViewById(R.id.tvFels);
        tvFels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, Frog_eye_leaf_spot.class);
                startActivity(intent);
            }
        });
        //Healthy
        tvHealthy = findViewById(R.id.tvHealthy);
        tvHealthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, Healthy.class);
                startActivity(intent);
            }
        });
        //PM
        tvPM = findViewById(R.id.tvPM);
        tvPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, Powdery_mildew.class);
                startActivity(intent);
            }
        });
        //Rust
        tvRust = findViewById(R.id.tvRust);
        tvRust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, Rust.class);
                startActivity(intent);
            }
        });
        //Scab
        tvScab = findViewById(R.id.tvScab);
        tvScab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diseases.this, Scab.class);
                startActivity(intent);
            }
        });

        btnDiseaseInicio = findViewById(R.id.btnDiseaseInicio);
        btnDiseaseInicio.setOnClickListener(v -> {
            Intent intent = new Intent(Diseases.this, MainActivity.class);
            startActivity(intent);
        });

    }
}