package com.example.aprendeingles;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Annadir extends AppCompatActivity {
    DAOPalabra daoPalabra = new DAOPalabra(this);
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
                if(!txtAnnadirPalabraIng.getText().toString().isEmpty() && !txtAnnadirPalabraEsp.getText().toString().isEmpty()) {
                    if (radioBtnExpresion.isChecked() || radioBtnPalabra.isChecked()) {
                        if (radioBtnExpresion.isChecked()){
                            daoPalabra.insertarPalabra(new Palabra(txtAnnadirPalabraIng.getText().toString(), txtAnnadirPalabraEsp.getText().toString(), TipoPalabra.EXPRESION.toString()));
                        }

                        else if (radioBtnPalabra.isChecked()){
                            daoPalabra.insertarPalabra(new Palabra(txtAnnadirPalabraIng.getText().toString(), txtAnnadirPalabraEsp.getText().toString(), TipoPalabra.PALABRA.toString()));
                        }
                    }
                }
            }
        });

        Button btnModificar = findViewById(R.id.btnModificarPalabra);
        EditText txtModificarPalabraIng = findViewById(R.id.txtModificarPalabraIng);
        EditText txtModificarPalabraIng2 = findViewById(R.id.txtModificarPalabraIng2);
        EditText txtModificarPalabraEsp = findViewById(R.id.txtModificarPalabraEsp);
        EditText txtModificarPalabraEsp2 = findViewById(R.id.txtModificarPalabraEsp2);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtModificarPalabraIng.getText().toString().isEmpty() && !txtModificarPalabraEsp.getText().toString().isEmpty()
                  && !txtModificarPalabraIng2.getText().toString().isEmpty() && !txtModificarPalabraEsp2.getText().toString().isEmpty()){

                    daoPalabra.modificarPalabra(txtModificarPalabraIng.getText().toString(), txtModificarPalabraIng2.getText().toString(), txtModificarPalabraEsp2.getText().toString());
                }
            }
        });
    }
}
