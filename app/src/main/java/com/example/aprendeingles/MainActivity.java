package com.example.aprendeingles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Palabra> listaPalabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        Button btnAprender = findViewById(R.id.btnEstudiar);
        btnAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Aprender.class);
                startActivity(intent);
            }
        });

        Button btnAnnadir = findViewById(R.id.btnAnnadir);
        btnAnnadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Annadir.class);
                startActivity(intent);
            }
        });

        Button btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buscar.class);
                startActivity(intent);
            }
        });

        //Datos iniciales de la lista
        listaPalabras = new ArrayList<Palabra>();
        listaPalabras.add(new Palabra("Milk", "Leche", TipoPalabra.PALABRA, new GregorianCalendar(13,02,2021), 0));
        listaPalabras.add(new Palabra("Cow", "Vaca", TipoPalabra.PALABRA, new GregorianCalendar(21,01,2021), 0));
        listaPalabras.add(new Palabra("House", "Casa", TipoPalabra.PALABRA, new GregorianCalendar(03,03,2021), 0));
        listaPalabras.add(new Palabra("Horse", "Caballo", TipoPalabra.PALABRA, new GregorianCalendar(17,03,2021), 0));
    }
}