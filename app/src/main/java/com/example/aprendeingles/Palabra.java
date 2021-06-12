package com.example.aprendeingles;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Palabra {
    String traduceEnglish;
    String traduceSpanish;
    String tipoPalabra;
    LocalDateTime fechaIntro;
    String fechaUltTest;
    int numAciertosTest;

    Palabra(String traduceEnglish, String traduceSpanish, String tipoPalabra, String fechaUltTest, int numAciertosTest){
        this.traduceEnglish = traduceEnglish;
        this.traduceSpanish = traduceSpanish;
        this.tipoPalabra = tipoPalabra;
        this.fechaIntro = LocalDateTime.now();
        this.fechaUltTest = fechaUltTest;
        this.numAciertosTest = numAciertosTest;
    }

    Palabra(String traduceEnglish, String traduceSpanish, String tipoPalabra){
        this.traduceEnglish = traduceEnglish;
        this.traduceSpanish = traduceSpanish;
        this.tipoPalabra = tipoPalabra;
    }

    Palabra(String traduceEnglish) {
        this.traduceEnglish = traduceEnglish;
    }

    public String getTraduceEnglish() {
        return traduceEnglish;
    }

    public void setTraduceEnglish(String traduceEnglish) {
        this.traduceEnglish = traduceEnglish;
    }

    public String getTraduceSpanish() {
        return traduceSpanish;
    }

    public void setTraduceSpanish(String traduceSpanish) {
        this.traduceSpanish = traduceSpanish;
    }

    public String getTipoPalabra() {
        return tipoPalabra;
    }

    public void setTipoPalabra(String tipoPalabra) {
        this.tipoPalabra = tipoPalabra;
    }

    public LocalDateTime getFechaIntro() {
        return fechaIntro;
    }

    public void setFechaIntro(LocalDateTime fechaIntro) {
        this.fechaIntro = fechaIntro;
    }

    public String getFechaUltTest() {
        return fechaUltTest;
    }

    public void setFechaUltTest(String fechaUltTest) {
        this.fechaUltTest = fechaUltTest;
    }

    public int getNumAciertosTest() {
        return numAciertosTest;
    }

    public void setNumAciertosTest(int numAciertosTest) {
        this.numAciertosTest = numAciertosTest;
    }
}
