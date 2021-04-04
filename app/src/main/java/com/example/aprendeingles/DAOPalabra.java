package com.example.aprendeingles;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DAOPalabra{
    ArrayList<Palabra> listaPalabras;

    DAOPalabra(){
        listaPalabras = new ArrayList<Palabra>();
        //Datos iniciales de la lista
        listaPalabras = new ArrayList<Palabra>();
        listaPalabras.add(new Palabra("Milk", "Leche", TipoPalabra.PALABRA, new GregorianCalendar(13,02,2021), 0));
        listaPalabras.add(new Palabra("Cow", "Vaca", TipoPalabra.PALABRA, new GregorianCalendar(21,01,2021), 0));
        listaPalabras.add(new Palabra("House", "Casa", TipoPalabra.PALABRA, new GregorianCalendar(03,03,2021), 0));
        listaPalabras.add(new Palabra("Horse", "Caballo", TipoPalabra.PALABRA, new GregorianCalendar(17,03,2021), 0));
    }

    public void insertarPalabra(String palabraIng, String palabraEsp, TipoPalabra tipo){
        listaPalabras.add(new Palabra(palabraIng, palabraEsp, tipo, new GregorianCalendar(0,0,0),0));
    }

    public void modificarPalabra(Palabra palabra, Palabra nuevaPalabra){
        if(listaPalabras.contains(palabra)){
            listaPalabras.remove(palabra);
            listaPalabras.add(nuevaPalabra);
        }
    }
}
