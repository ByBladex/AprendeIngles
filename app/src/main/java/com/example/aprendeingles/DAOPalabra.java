package com.example.aprendeingles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class DAOPalabra{
    public static ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>();
    public static ArrayList<Palabra> listaPalabrasCopia= new ArrayList<Palabra>();
    public static ArrayList<String> palabrasIng;
    public static ArrayList<Palabra> test= new ArrayList<Palabra>();
    public static Palabra palabra;
    private static int ind=0;
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

    public static void modificarPalabra(String palabraÍng, String palabraEsp, String nuevaPalabraIng, String nuevaPalabraEsp){
        for (int i=0;i<listaPalabrasCopia.size();i++) {
            if(listaPalabrasCopia.get(i).traduceEnglish.equals(palabraÍng) &&
                    listaPalabrasCopia.get(i).traduceSpanish.equals(palabraEsp)) {

                listaPalabrasCopia.get(i).setTraduceEnglish(nuevaPalabraIng);
                listaPalabrasCopia.get(i).setTraduceSpanish(nuevaPalabraEsp);
            }
        }
    }

    public static void crearListaCopia(){
        if(listaPalabrasCopia.isEmpty()){
            for (Palabra palabra:listaPalabras) {
                listaPalabrasCopia.add(palabra);
            }
        }
    }

    public static void sumarAcierto(String palabraEsp){
        for(int i=0;i<listaPalabrasCopia.size();i++){
            if(listaPalabrasCopia.get(i).traduceSpanish.equals(palabraEsp))
                listaPalabrasCopia.get(i).numAciertosTest++;
        }
    }

    public static String generarPalabraAleatoria(){
        palabra = test.get(ind);
        ind++;
        String siguientePalabra = palabra.traduceEnglish + " " + palabra.numAciertosTest;

        return siguientePalabra;
    }

    public static void generarRespuestasAleatorias(ArrayList<String> respuestas) {
        while (respuestas.size() < 3) {
            int randomIndex = (int) (Math.random() * listaPalabrasCopia.size());
            Palabra randomRespuesta = listaPalabrasCopia.get(randomIndex);
            if (!randomRespuesta.traduceSpanish.equals(palabra.traduceSpanish) && !respuestas.contains(randomRespuesta.traduceSpanish))
                respuestas.add(randomRespuesta.traduceSpanish);
        }
        respuestas.add(palabra.traduceSpanish);
        Collections.shuffle(respuestas);
    }

    public static void mostrarTodo(){
        palabrasIng = new ArrayList<String>();
        Collections.shuffle(listaPalabrasCopia);
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceEnglish;
            palabrasIng.add(palabraIng);
        }
    }

    public static void ordenAlfabetico(){
        palabrasIng = new ArrayList<String>();
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceEnglish;
            palabrasIng.add(palabraIng);
        }
        Collections.sort(palabrasIng, new OrdenAlfabeticoComparator());
    }

    public static void ordenAciertos(){
        palabrasIng = new ArrayList<String>();
        Collections.sort(listaPalabrasCopia, (new Comparator<Palabra>() {
            public int compare(Palabra i1, Palabra i2) {
                return i1.numAciertosTest.compareTo(i2.numAciertosTest);
            }
        }).reversed());
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceEnglish;
            palabrasIng.add(palabraIng);
        }
    }

    public static void mostrarIngles(){
        ordenAlfabetico();
    }

    public static void mostrarEspanol(){
        palabrasIng = new ArrayList<String>();
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceSpanish;
            palabrasIng.add(palabraIng);
        }
    }

    public static void mostrarSoloPalabras(){
        palabrasIng = new ArrayList<String>();
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceEnglish;
            if(listaPalabrasCopia.get(i).tipoPalabra.equals(TipoPalabra.PALABRA))
                palabrasIng.add(palabraIng);
        }
        Collections.sort(palabrasIng, new OrdenAlfabeticoComparator());
    }

    public static void mostrarSoloExpresiones(){
        palabrasIng = new ArrayList<String>();
        for(int i=0;i<listaPalabrasCopia.size();i++)
        {
            String palabraIng = listaPalabrasCopia.get(i).traduceEnglish;
            if(listaPalabrasCopia.get(i).tipoPalabra.equals(TipoPalabra.EXPRESION))
                palabrasIng.add(palabraIng);
        }
        Collections.sort(palabrasIng, new OrdenAlfabeticoComparator());
    }

    public void generarTest(){
        ordenAciertos();
        for (int i=0;i<5;i++){
            test.add(listaPalabrasCopia.get((listaPalabrasCopia.size()-1)-i));
        }
    }

    public void reiniciarTest(){
        test.clear();
    }
}
