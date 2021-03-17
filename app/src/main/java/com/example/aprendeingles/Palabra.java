package com.example.aprendeingles;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Palabra {
    String traduceEnglish;
    String traduceSpanish;
    TipoPalabra tipoPalabra;
    LocalDateTime fechaIntro;
    GregorianCalendar fechaUltTest;
    Integer numAciertosTest;

    Palabra(String traduceEnglish, String traduceSpanish, TipoPalabra tipoPalabra, GregorianCalendar fechaUltTest, Integer numAciertosTest){
        this.traduceEnglish = traduceEnglish;
        this.traduceSpanish = traduceSpanish;
        this.tipoPalabra = tipoPalabra;
        this.fechaIntro = LocalDateTime.now();
        this.fechaUltTest = fechaUltTest;
        this.numAciertosTest = numAciertosTest;
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

    public TipoPalabra getTipoPalabra() {
        return tipoPalabra;
    }

    public void setTipoPalabra(TipoPalabra tipoPalabra) {
        this.tipoPalabra = tipoPalabra;
    }

    public LocalDateTime getFechaIntro() {
        return fechaIntro;
    }

    public void setFechaIntro(LocalDateTime fechaIntro) {
        this.fechaIntro = fechaIntro;
    }

    public GregorianCalendar getFechaUltTest() {
        return fechaUltTest;
    }

    public void setFechaUltTest(GregorianCalendar fechaUltTest) {
        this.fechaUltTest = fechaUltTest;
    }

    public Integer getNumAciertosTest() {
        return numAciertosTest;
    }

    public void setNumAciertosTest(Integer numAciertosTest) {
        this.numAciertosTest = numAciertosTest;
    }


}
