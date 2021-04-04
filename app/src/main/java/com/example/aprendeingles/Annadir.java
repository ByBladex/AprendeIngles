package com.example.aprendeingles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Annadir extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annadir);

        Button btnAnnadir = findViewById(R.id.btnAñadirPalabra);
        EditText txtAnnadirPalabraIng = findViewById(R.id.txtAnnadirPalabraIng);
        EditText txtAnnadirPalabraEsp = findViewById(R.id.txtAnnadirPalabraEsp);
        RadioButton radioBtnPalabra = findViewById(R.id.radioBtnPalabra);
        RadioButton radioBtnExpresion = findViewById(R.id.radioBtnExpresion);
        btnAnnadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(radioBtnExpresion.isChecked() || radioBtnPalabra.isChecked()){
                    if(radioBtnExpresion.isChecked())
                        daoPalabra.insertarPalabra(txtAnnadirPalabraIng.getText().toString(), txtAnnadirPalabraEsp.getText().toString(), TipoPalabra.EXPRESION);

                    else if(radioBtnPalabra.isChecked())
                        daoPalabra.insertarPalabra(txtAnnadirPalabraIng.getText().toString(), txtAnnadirPalabraEsp.getText().toString(), TipoPalabra.PALABRA);
                }
            }
        });
    }
}
