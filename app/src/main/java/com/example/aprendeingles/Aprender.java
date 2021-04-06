package com.example.aprendeingles;

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

        //Etiqueta en la que saldrá la palabra aleatoria
        TextView lblPalabra = findViewById(R.id.lblPalabra);

        //Botones
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);

        //Array botones de las respuestas
        Button[] botonesRespuestas = {btn1,btn2,btn3,btn4};
        for(int i=0;i<botonesRespuestas.length-1;i++){
            int randomIndBtn = (int)(Math.random()*botonesRespuestas.length);
            botonesRespuestas[randomIndBtn].setText();
        }


        //Random de la palabra en ingles aleatoria
        int randomInd = (int)(Math.random()*daoPalabra.listaPalabrasCopia.size());
        Palabra random = daoPalabra.listaPalabrasCopia.get(randomInd);
        lblPalabra.setText(random.traduceEnglish);
        //btn1.setText(""+ daoPalabra.listaPalabrasCopia.size());
    }
}
