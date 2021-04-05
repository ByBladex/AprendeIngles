package com.example.aprendeingles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class DAOPalabra{
    public static ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>();
    public static ArrayList<Palabra> listaPalabrasCopia= new ArrayList<Palabra>();

    DAOPalabra(){
        //Datos iniciales de la lista
        this.listaPalabras.add(new Palabra("Milk", "Leche", TipoPalabra.PALABRA, new GregorianCalendar(13,02,2021), 0));
        this.listaPalabras.add(new Palabra("Cow", "Vaca", TipoPalabra.PALABRA, new GregorianCalendar(21,01,2021), 0));
        this.listaPalabras.add(new Palabra("House", "Casa", TipoPalabra.PALABRA, new GregorianCalendar(03,03,2021), 0));
        this.listaPalabras.add(new Palabra("Horse", "Caballo", TipoPalabra.PALABRA, new GregorianCalendar(17,03,2021), 0));
        this.listaPalabras.add(new Palabra("Lettuce", "Lechuga", TipoPalabra.PALABRA, new GregorianCalendar(07,02,2021), 0));
        this.listaPalabras.add(new Palabra("My name is Jeff", "Mi nombre es Jeff", TipoPalabra.EXPRESION, new GregorianCalendar(10,03,2021), 0));
        this.listaPalabras.add(new Palabra("Hello, whats your name?", "Hola, ¿como te llamas?", TipoPalabra.EXPRESION, new GregorianCalendar(17,03,2021), 0));
        this.listaPalabras.add(new Palabra("I live in Jerez", "Yo vivo en Jerez", TipoPalabra.EXPRESION, new GregorianCalendar(16,01,2021), 0));
        this.listaPalabras.add(new Palabra("I have a pencil", "Yo tengo un lapiz", TipoPalabra.EXPRESION, new GregorianCalendar(04,04,2021), 0));

        Collections.shuffle(listaPalabras);
    }

    public static void insertarPalabra(String palabraIng, String palabraEsp, TipoPalabra tipo){
        listaPalabrasCopia.add(new Palabra(palabraIng, palabraEsp, tipo, new GregorianCalendar(0,0,0),0));
        Collections.shuffle(listaPalabrasCopia);
    }

    public static void modificarPalabra(Palabra palabra, Palabra nuevaPalabra){
        if(listaPalabras.contains(palabra)){
            listaPalabras.remove(palabra);
            listaPalabras.add(nuevaPalabra);
        }
    }

    public static void crearListaCopia(){
        for (Palabra palabra:listaPalabras) {
            listaPalabrasCopia.add(palabra);
        }
    }
}
