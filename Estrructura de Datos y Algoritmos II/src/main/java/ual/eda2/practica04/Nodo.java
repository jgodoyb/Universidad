package ual.eda2.practica04;

import java.util.Arrays;

public class Nodo implements Comparable<Nodo> {

    private int nivel;
    private int[] s;
    private double bact;
    private double estimado;

    public Nodo(int nivel, int[] s, double bact, double estimado) {
        this.nivel = nivel;
        this.s = s.clone();
        this.bact = bact;
        this.estimado = estimado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int[] getS() {
        return s;
    }

    public void setS(int[] s) {
        this.s = s.clone();
    }

    public double getBact() {
        return bact;
    }

    public void setBact(double bact) {
        this.bact = bact;
    }

    public double getEstimado() {
        return estimado;
    }

    public void setEstimado(double estimado) {
        this.estimado = estimado;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "nivel=" + nivel +
                ", s=" + Arrays.toString(s) +
                ", bact=" + bact +
                ", estimado=" + estimado +
                '}';
    }

    @Override
    public int compareTo(Nodo other) {
        return -Double.compare(this.estimado, other.estimado);
    }
}
