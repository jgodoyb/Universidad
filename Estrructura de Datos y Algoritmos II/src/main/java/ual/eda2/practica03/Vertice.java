package ual.eda2.practica03;

import java.util.Objects;

public class Vertice implements Comparable<Vertice> {

    private String nombre;
    private double x, y;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.x = 0;
        this.y = 0;
    }

    public Vertice(String nombre, double x, double y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int hashCode() {
        return Objects.hash(nombre);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vertice vertice = (Vertice) obj;
        return Objects.equals(nombre, vertice.nombre);
    }

    @Override
    public int compareTo(Vertice o) {
        return this.nombre.compareTo(o.nombre);
    }

}
