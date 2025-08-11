package ual.eda2.practica01;

import java.util.Comparator;

public class XYComparator implements Comparator<Punto> {

    public int compare(Punto p1,Punto p2){
        int comp = Double.compare(p1.getX(), p2.getX());
        return comp == 0 ? Double.compare(p1.getY(), p2.getY()):comp;
    }
    
}
