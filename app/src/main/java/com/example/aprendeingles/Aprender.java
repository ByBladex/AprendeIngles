package com.example.aprendeingles;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Aprender extends AppCompatActivity {
    private IDAOPalabra daoPalabra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_aprender);
        daoPalabra = DAOPalabra.getInstance(getApplicationContext());

        daoPalabra.reiniciarTest();
        daoPalabra.generarTest();

        //Etiqueta en la que saldrá la palabra aleatoria
        TextView lblPalabra = findViewById(R.id.lblPalabra);

        //Botones
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);

        //ArrayList botones de las respuestas
        ArrayList<Button> botonesRespuestas = new ArrayList<Button>();
        botonesRespuestas.add(btn1);
        botonesRespuestas.add(btn2);
        botonesRespuestas.add(btn3);
        botonesRespuestas.add(btn4);
        Collections.shuffle(botonesRespuestas);

        //Random de la palabra en ingles aleatoria
        lblPalabra.setText(daoPalabra.generarPalabraAleatoria());
        //btn1.setText(""+ daoPalabra.listaPalabrasCopia.size());

        //Array respuestas
        ArrayList<String> respuestas = new ArrayList<String>();
        daoPalabra.generarRespuestasAleatorias(respuestas);

        for (int i=0;i<botonesRespuestas.size();i++){
            botonesRespuestas.get(i).setText(respuestas.get(i));
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn1.getText().toString().equals(daoPalabra.getPalabra().traduceSpanish)){
                    daoPalabra.sumarAcierto(daoPalabra.getPalabra().traduceSpanish);
                }
                if(!daoPalabra.getTest().isEmpty()){
                    finish();
                    startActivity(getIntent());
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2.getText().toString().equals(daoPalabra.getPalabra().traduceSpanish)){
                    daoPalabra.sumarAcierto(daoPalabra.getPalabra().traduceSpanish);
                }
                if(!daoPalabra.getTest().isEmpty()){
                    finish();
                    startActivity(getIntent());
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn3.getText().toString().equals(daoPalabra.getPalabra().traduceSpanish)){
                    daoPalabra.sumarAcierto(daoPalabra.getPalabra().traduceSpanish);
                }
                if(!daoPalabra.getTest().isEmpty()){
                    finish();
                    startActivity(getIntent());
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn4.getText().toString().equals(daoPalabra.getPalabra().traduceSpanish)){
                    daoPalabra.sumarAcierto(daoPalabra.getPalabra().traduceSpanish);
                }
                if(!daoPalabra.getTest().isEmpty()){
                    finish();
                    startActivity(getIntent());
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
