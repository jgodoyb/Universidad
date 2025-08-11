package ual.eda2.practica03;

import java.util.Objects;

public class Arista implements Comparable<Arista> {

    private Vertice origen, destino;
    private double peso;

    public Arista(Vertice origen, Vertice destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public int hashCode() {
        return Objects.hash(destino, origen);
    }

    public boolean equals(Object o) { // without peso
        if (this == o)
            return true;
        if (!(o instanceof Arista))
            return false;
        Arista arista = (Arista) o;
        return origen.equals(arista.origen) && destino.equals(arista.destino);
    }

    @Override
    public String toString() {
        return origen.getNombre() + " -> " + destino.getNombre() + " : " + peso;
    }

    public int compareTo(Arista o) {
        return Double.compare(this.peso, o.peso);
    }
}
