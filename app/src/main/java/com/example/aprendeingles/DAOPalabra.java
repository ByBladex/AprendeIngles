package com.example.aprendeingles;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DAOPalabra implements IDAOPalabra{
    private static IDAOPalabra dao = null;
    public static ArrayList<Palabra> listaPalabras;
    public static ArrayList<Palabra> palabrasIng;
    public static ArrayList<Palabra> test= new ArrayList<Palabra>();
    private ConexionSQLite conn;
    private SQLiteDatabase db;
    public static Palabra palabra;
    private static int ind=0;

    DAOPalabra(Context context){
        //Datos iniciales de la lista
        listaPalabras = new ArrayList<Palabra>();
        conn = new ConexionSQLite(context);

        rellenarListado();
    }

    public ArrayList<Palabra> getPalabrasIng(){
        return palabrasIng;
    }

    public ArrayList<String> getPalabrasToString(){
        ArrayList<String> cadena = new ArrayList<>();
        for (Palabra palabra:palabrasIng) {
            cadena.add(palabra.traduceEnglish);
        }
        return cadena;
    }

    public int rellenarListado(){
        try{
            db = conn.getWritableDatabase();
            listaPalabras.clear();
            if(db != null){
                Cursor c = db.rawQuery("SELECT * FROM Palabra", null);
                if(c.moveToFirst()){
                    do{
                        listaPalabras.add(new Palabra(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5)));
                    }
                    while(c.moveToNext());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        }
        catch(SQLException e){
            return 0;
        }
    }

    public int insertarPalabra(Palabra palabra){
        try{
            db = conn.getWritableDatabase();
            if(db!=null){
                db.execSQL("INSERT INTO Palabra (id, ingles, español, tipo, fechaintro,fechaulttest, numaciertos) " +
                        "VALUES ("+(listaPalabras.size()+1)+",'"+palabra.getTraduceEnglish()+"', '"+palabra.getTraduceSpanish()+"', '"+palabra.getTipoPalabra()+"', '"
                        +palabra.getFechaIntro()+"', '"+palabra.getFechaUltTest()+"', '"+palabra.getNumAciertosTest()+"')");
                rellenarListado();
                db.close();
                return 1;
            }
            else {
                return 0;
            }
        }
        catch(SQLException e){
            return 0;
        }
    }

    public int modificarPalabra(String palabraIng, String nuevaPalabraIng, String nuevaPalabraEsp){
        try{
            Palabra palabra = getPalabraIngles(palabraIng);
            db = conn.getWritableDatabase();
            if(db != null){
                db.execSQL("UPDATE Palabra SET ingles = '"+nuevaPalabraIng+"', español = '"+nuevaPalabraEsp+"' WHERE ingles = '"+palabra.getTraduceEnglish()+"'");
                db.close();
                rellenarListado();
                return 1;
            }
            rellenarListado();
            return 0;
        }
        catch (SQLException e){
            return 0;
        }
    }

    public Palabra getPalabraIngles(String ingles){
        for(Palabra palabra: listaPalabras){
            if(palabra.getTraduceEnglish().equals(ingles))
                return palabra;
        }
        return null;
    }

    public Palabra getPalabraEspañol(String español){
        for(Palabra palabra: listaPalabras){
            if(palabra.getTraduceSpanish().equals(español))
                return palabra;
        }
        return null;
    }

    public Palabra getPalabraPorPos(int posicion){
        return palabrasIng.get(posicion);
    }

    public int eliminarPalabra(Palabra palabra){
        try{
            db = conn.getWritableDatabase();
            if(db!=null){
                db.execSQL("DELETE FROM Palabra WHERE ingles = '"+palabra.getTraduceEnglish()+"'");
                db.close();
                rellenarListado();
                return 1;
            }
            rellenarListado();
            return 0;
        }
        catch(SQLException e){
            return 0;
        }
    }

    public int sumarAcierto(String palabraEsp){
        try{
            Palabra palabra = getPalabraEspañol(palabraEsp);
            db = conn.getWritableDatabase();
            if(db != null){
                db.execSQL("UPDATE Palabra SET numaciertos = '"+(palabra.getNumAciertosTest()+1)+"' WHERE español = '"+palabra.getTraduceSpanish()+"'");
                db.close();
                rellenarListado();
                return 1;
            }
            rellenarListado();
            return 0;
        }
        catch (SQLException e){
            return 0;
        }
    }

    public String generarPalabraAleatoria(){
        palabra = test.get(ind);
        ind++;
        String siguientePalabra = palabra.traduceEnglish + " " + palabra.numAciertosTest;

        return siguientePalabra;
    }

    public void generarRespuestasAleatorias(ArrayList<String> respuestas) {
        while (respuestas.size() < 3) {
            int randomIndex = (int) (Math.random() * listaPalabras.size());
            Palabra randomRespuesta = listaPalabras.get(randomIndex);
            if (!randomRespuesta.traduceSpanish.equals(palabra.traduceSpanish) && !respuestas.contains(randomRespuesta.traduceSpanish))
                respuestas.add(randomRespuesta.traduceSpanish);
        }
        respuestas.add(palabra.traduceSpanish);
        Collections.shuffle(respuestas);
    }

    public int mostrarTodo() {
        try {
            palabrasIng = new ArrayList<Palabra>();
            db = conn.getWritableDatabase();
            if (db != null) {
                Cursor c = db.rawQuery("SELECT ingles FROM Palabra", null);
                if (c.moveToFirst()) {
                    do {
                        palabrasIng.add(new Palabra(c.getString(0)));
                    }
                    while (c.moveToNext());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int ordenAlfabetico(){
            try {
                palabrasIng = new ArrayList<Palabra>();
                db = conn.getWritableDatabase();
                if (db != null) {
                    Cursor c = db.rawQuery("SELECT ingles FROM Palabra", null);
                    if (c.moveToFirst()){
                        do {
                            palabrasIng.add(new Palabra(c.getString(0)));
                        }
                        while (c.moveToNext());
                    }
                    c.close();
                    db.close();
                    Collections.sort(palabrasIng, new OrdenAlfabeticoComparator());
                    return 1;
                }
                return 0;
            }
            catch (SQLException e) {
                return 0;
            }
    }

    public int ordenAciertos(){
        try {
            palabrasIng = new ArrayList<Palabra>();
            db = conn.getWritableDatabase();
            if (db != null) {
                Cursor c = db.rawQuery("SELECT ingles FROM Palabra", null);
                if (c.moveToFirst()) {
                    do {
                        palabrasIng.add(new Palabra(c.getString(0)));
                    }
                    while (c.moveToNext());
                    Collections.sort(palabrasIng, new Comparator<Palabra>() {
                        public int compare(Palabra i1, Palabra i2) {
                            return String.valueOf(i1.getNumAciertosTest()).compareTo(String.valueOf(i2.getNumAciertosTest()));
                        }
                    }.reversed());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void mostrarIngles(){
        ordenAlfabetico();
    }

    public int mostrarEspanol() {
        try {
            palabrasIng = new ArrayList<Palabra>();
            db = conn.getWritableDatabase();
            if (db != null) {
                Cursor c = db.rawQuery("SELECT español FROM Palabra", null);
                if (c.moveToFirst()) {
                    do {
                        palabrasIng.add(new Palabra(c.getString(0)));
                    }
                    while (c.moveToNext());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int mostrarSoloPalabras(){
        try {
            palabrasIng = new ArrayList<Palabra>();
            db = conn.getWritableDatabase();
            if (db != null) {
                Cursor c = db.rawQuery("SELECT ingles FROM Palabra WHERE tipo = 'PALABRA'", null);
                if (c.moveToFirst()){
                    do {
                        palabrasIng.add(new Palabra(c.getString(0)));
                    }
                    while (c.moveToNext());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        }
        catch (SQLException e) {
            return 0;
        }
    }

    public int mostrarSoloExpresiones(){
            try {
                palabrasIng = new ArrayList<Palabra>();
                db = conn.getWritableDatabase();
                if (db != null) {
                    Cursor c = db.rawQuery("SELECT ingles FROM Palabra WHERE tipo = 'EXPRESION'", null);
                    if (c.moveToFirst()){
                        do {
                            palabrasIng.add(new Palabra(c.getString(0)));
                        }
                        while (c.moveToNext());
                    }
                    c.close();
                    db.close();
                    return 1;
                }
                return 0;
            }
            catch (SQLException e) {
                return 0;
            }
    }

    public void generarTest(){
        ordenAciertos();
        for (int i=0;i<5;i++){
            test.add(listaPalabras.get((listaPalabras.size()-1)-i));
        }
    }

    public void reiniciarTest(){
        test.clear();
    }

    public Palabra getPalabra(){
        return palabra;
    }

    public ArrayList<Palabra> getTest(){
        return test;
    }

    public static IDAOPalabra getInstance(Context context) {
        if (dao == null) dao = new DAOPalabra(context);

        return dao;
    }
}
