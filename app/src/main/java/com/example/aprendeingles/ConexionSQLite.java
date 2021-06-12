package com.example.aprendeingles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.time.LocalDate;

public class ConexionSQLite extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "bd_aprendeingles";

    String sqlCreate = "CREATE TABLE Palabra (ingles TEXT PRIMARY KEY,"+
            "español TEXT NOT NULL," +
            "tipo TEXT NOT NULL," +
            "fechaintro TEXT NOT NULL," +
            "fechaulttest TEXT NOT NULL," +
            "numaciertos INT NOT NULL)";

    public ConexionSQLite(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL("INSERT INTO Palabra (id, ingles, español, tipo, fechaintro, fechaulttest, numaciertos) VALUES ('1','Milk','Leche', 'PALABRA', '13,02,2021','15,02,2021',0), ('2','Cow','Vaca','PALABRA', '13,02,2021', '14,02,2021',0), ('3','House','Casa','PALABRA', '13,02,2021', '14,02,2021',0), ('4','Milk','Leche','PALABRA', '13,02,2021', '13,02,2021',0)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Palabra");
        onCreate(db);
    }
}
