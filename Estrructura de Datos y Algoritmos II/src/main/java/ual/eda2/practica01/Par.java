package ual.eda2.practica01;

public class Par {

    private Punto p1, p2;
    private double distancia;

    public Par(Punto p1, Punto p2, double distancia) {
        this.p1 = p1;
        this.p2 = p2;
        this.distancia = distancia;
    }

    public Par() {
        this.p1 = null;
        this.p2 = null;
        this.distancia = Double.MAX_VALUE;
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public double getDistancia() {
        return distancia;
    }

    public String toString() {
        if (p1 == null || p2 == null) {
            return "Par vacio";
        }
        return "Par { " + p1 + ", " + p2 + ", distancia=" + Utilidades.format(distancia) + '}';
    }

}
