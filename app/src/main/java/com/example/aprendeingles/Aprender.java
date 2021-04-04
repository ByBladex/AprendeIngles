package com.example.aprendeingles;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Aprender extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_aprender);

        TextView lblPalabra = findViewById(R.id.lblPalabra);

        Random randomizer = new Random();
        Palabra random = daoPalabra.listaPalabras.get(randomizer.nextInt(daoPalabra.listaPalabras.size()));
        lblPalabra.setText(random.traduceEnglish);
    }
}
