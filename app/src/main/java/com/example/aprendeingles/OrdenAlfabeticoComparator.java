package com.example.aprendeingles;

import java.util.Comparator;

public class OrdenAlfabeticoComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
