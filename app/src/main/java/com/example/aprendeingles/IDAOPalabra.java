package com.example.aprendeingles;

import java.util.ArrayList;

public interface IDAOPalabra {
    public int rellenarListado();
    public int insertarPalabra(Palabra palabra);
    public int modificarPalabra(String palabraIng, String nuevaPalabraIng, String nuevaPalabraEsp);
    public Palabra getPalabraIngles(String ingles);
    public Palabra getPalabraEspañol(String español);
    public Palabra getPalabraPorPos(int posicion);
    public int eliminarPalabra(Palabra palabra);
    public int sumarAcierto(String palabraEsp);
    public String generarPalabraAleatoria();
    public void generarRespuestasAleatorias(ArrayList<String> respuestas);
    public int mostrarTodo();
    public int ordenAlfabetico();
    public int ordenAciertos();
    public void mostrarIngles();
    public ArrayList<Palabra> getPalabrasIng();
    public int mostrarEspanol();
    public int mostrarSoloPalabras();
    public int mostrarSoloExpresiones();
    public void generarTest();
    public void reiniciarTest();
    public Palabra getPalabra();
    public ArrayList<Palabra> getTest();
    public ArrayList<String> getPalabrasToString();
}
