package com.example.aprendeingles;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Buscar extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_buscar);

        ListView listViewPalabras = findViewById(R.id.listViewPalabras);
        ArrayList<String> palabrasIng = new ArrayList<>();

        String[] array = new String[4];
        array[0] = "Hola";
        array[1] = "Que tal";
        array[2] = "Buenas";
        array[3] = "Adios";

        /*for(int i=0;i<daoPalabra.listaPalabrasCopia.size();i++)
        {
            Palabra palabra = daoPalabra.listaPalabrasCopia.get(i);
            palabrasIng.add(palabra.traduceEnglish);
        }*/

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
        listViewPalabras.setAdapter(adaptador);
    }
}
