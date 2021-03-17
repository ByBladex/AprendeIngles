package com.example.aprendeingles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    ArrayList<Palabra> listaPalabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Datos iniciales de la lista
        listaPalabras = new ArrayList<Palabra>();
        listaPalabras.add(new Palabra("Milk", "Leche", TipoPalabra.PALABRA, new GregorianCalendar(13,02,2021), 0));
        listaPalabras.add(new Palabra("Cow", "Vaca", TipoPalabra.PALABRA, new GregorianCalendar(21,01,2021), 0));
        listaPalabras.add(new Palabra("House", "Casa", TipoPalabra.PALABRA, new GregorianCalendar(03,03,2021), 0));
        listaPalabras.add(new Palabra("Horse", "Caballo", TipoPalabra.PALABRA, new GregorianCalendar(17,03,2021), 0));


    }

    public void añadir(View v) {
        setContentView(R.layout.activity_annadir);
    }

    public void atras(View v){
        setContentView(R.layout.activity_main);
    }

}