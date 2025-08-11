package ual.eda2.practica01;

import java.util.Comparator;

public class XComparator implements Comparator<Punto> {

    public int compare(Punto p1, Punto p2) {
        return Double.compare(p1.getX(), p2.getX());

    }

}
