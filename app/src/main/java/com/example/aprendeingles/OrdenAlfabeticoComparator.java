package com.example.aprendeingles;

import java.util.Comparator;

public class OrdenAlfabeticoComparator implements Comparator<Palabra> {

    @Override
    public int compare(Palabra o1, Palabra o2) {
        return o1.traduceEnglish.compareToIgnoreCase(o2.traduceEnglish);
    }
}
