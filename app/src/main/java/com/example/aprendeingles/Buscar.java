package com.example.aprendeingles;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Buscar extends AppCompatActivity {
    private IDAOPalabra daoPalabra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_buscar);
        daoPalabra = DAOPalabra.getInstance(getApplicationContext());

        RadioButton radioBtnOrdenAlf = findViewById(R.id.radioBtnOrdenAlf);
        RadioButton radioBtnOrdenAciertos = findViewById(R.id.radioBtnOrdenAciertos);
        RadioButton radioBtnIngles = findViewById(R.id.radioBtnIngles);
        RadioButton radioBtnEspanol = findViewById(R.id.radioBtnEspannol);
        RadioButton radioBtnPalabra = findViewById(R.id.radioBtnOrdenPalabra);
        RadioButton radioBtnExpresion = findViewById(R.id.radioBtnOrdenExp);

        final RadioGroup group2= (RadioGroup) findViewById(R.id.radioGroup2);
        if(!radioBtnOrdenAlf.isChecked() && !radioBtnOrdenAciertos.isChecked() && !radioBtnIngles.isChecked() && !radioBtnEspanol.isChecked() && !radioBtnPalabra.isChecked() && !radioBtnExpresion.isChecked())
            daoPalabra.mostrarTodo();
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = group2.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radioBtnOrdenAlf:
                        daoPalabra.ordenAlfabetico();
                        break;
                    case R.id.radioBtnOrdenAciertos:
                        daoPalabra.ordenAciertos();
                        break;
                    case R.id.radioBtnIngles:
                        daoPalabra.mostrarIngles();
                        break;
                    case R.id.radioBtnEspannol:
                        daoPalabra.mostrarEspanol();
                        break;
                    case R.id.radioBtnOrdenPalabra:
                        daoPalabra.mostrarSoloPalabras();
                        break;
                    case R.id.radioBtnOrdenExp:
                        daoPalabra.mostrarSoloExpresiones();
                        break;
                }
            }
        });

        Button btnFiltrar = findViewById(R.id.btnFiltrado);
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Filtrado.class);
                startActivity(intent);
            }
        });
    }
}
