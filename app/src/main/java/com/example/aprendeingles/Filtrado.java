package com.example.aprendeingles;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Filtrado extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_filtrado);
        ArrayList<String> palabrasIng = new ArrayList<String>();

        ListView listViewPalabras = findViewById(R.id.listViewPalabras);

        for(int i=0;i<daoPalabra.listaPalabrasCopia.size();i++)
        {
            String palabraIng = daoPalabra.listaPalabrasCopia.get(i).traduceEnglish;
            palabrasIng.add(palabraIng);
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, palabrasIng);
        listViewPalabras.setAdapter(adaptador);
    }
}
