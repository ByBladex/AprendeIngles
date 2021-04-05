package com.example.aprendeingles;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.Random;

public class Aprender extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_aprender);

        if(daoPalabra.listaPalabrasCopia.isEmpty())
            daoPalabra.crearListaCopia();

        TextView lblPalabra = findViewById(R.id.lblPalabra);
        Button btnCACA = findViewById(R.id.button);

        int randomIndex = (int)(Math.random()*daoPalabra.listaPalabrasCopia.size());
        Palabra random = daoPalabra.listaPalabrasCopia.get(randomIndex);
        lblPalabra.setText(random.traduceEnglish);
        btnCACA.setText(""+ daoPalabra.listaPalabrasCopia.size());
    }
}
