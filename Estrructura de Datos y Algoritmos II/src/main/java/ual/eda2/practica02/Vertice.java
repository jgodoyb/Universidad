package ual.eda2.practica02;

public class Vertice implements Comparable<Vertice> {

    private String identificador;
    private double x, y, costeAcumulado, heuristica, sumaCosteHeuristica;
    private Vertice anterior;

    public Vertice(String identificador) {
        this(identificador, 0, 0);
    }

    public Vertice(String identificador, double x, double y) {
        this(identificador, x, y, 0, 0, 0, null);
    }

    public Vertice(String identificador, double x, double y, double costeAcumulado, double heuristica,
            double sumaCosteHeuristica, Vertice anterior) {
        this.identificador = identificador;
        this.x = x;
        this.y = y;
        this.costeAcumulado = costeAcumulado;
        this.heuristica = heuristica;
        this.sumaCosteHeuristica = sumaCosteHeuristica;
        this.anterior = anterior;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCosteAcumulado() {
        return costeAcumulado;
    }

    public void setCosteAcumulado(double costeAcumulado) {
        this.costeAcumulado = costeAcumulado;
    }

    public double heuristicaDistanciaEuclidea(Vertice destino) {
        return (Math.sqrt(Math.pow(this.x - destino.getX(), 2) + Math.pow(this.y - destino.getY(), 2)));
    }

    public double getHeuristica() {
        return this.heuristica;
    }

    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    public void setSumaCosteHeuristica(double sumaCosteHeuristica) {
        this.sumaCosteHeuristica = sumaCosteHeuristica;
    }

    public double getSumaCosteHueristica() {
        return this.sumaCosteHeuristica;
    }

    public Vertice getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return this.identificador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Vertice other = (Vertice) obj;
        return identificador.equals(other.identificador);
    }

    @Override
    public int hashCode() {
        return identificador.hashCode();
    }

    @Override
    public int compareTo(Vertice other) {
        return Double.compare(sumaCosteHeuristica, other.sumaCosteHeuristica);
    }
}