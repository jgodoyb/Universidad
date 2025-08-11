package ual.eda2.practica02;

import java.util.Comparator;

public class TripleComparator implements Comparator<Triple<Vertice, Double, Vertice>> {

    @Override
    public int compare(Triple<Vertice, Double, Vertice> o1, Triple<Vertice, Double, Vertice> o2) {
      
        return o1.getValor().compareTo(o2.getValor()); // El orden se invierte aquí para priorizar el mayor valor
    }
}
