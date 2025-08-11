package ual.eda2.practica03;

import java.util.LinkedList;
import java.util.List;

public class Solucion {

    private List<Vertice> resultado;
    private double distancia;

    public Solucion(List<Vertice> resultados, double distancia) {
        this.resultado = new LinkedList<>(resultados);
        this.distancia = distancia;
    }

    public Solucion() {
        this.resultado = new LinkedList<>();
        this.distancia = Double.POSITIVE_INFINITY;
    }

    public List<Vertice> getResultado() {
        return resultado;
    }

    public double getDistancia() {
        return distancia;
    }

    public void addVertice(Vertice vertice) {
        resultado.add(vertice);
    }

    public void remove(int index) {
        resultado.remove(index);
    }

    public void removeLast() {
        resultado.remove(resultado.size() - 1);
    }

    public Vertice get(int index) {
        return resultado.get(index);
    }

    public int size() {
        return resultado.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camino: ");

        if (resultado != null && !resultado.isEmpty()) {
            for (Vertice vertice : resultado) {
                sb.append(vertice.getNombre()).append(" -> ");
            }
            sb.delete(sb.length() - 4, sb.length()); // Eliminar la última flecha
        } else {
            sb.append("vacío");
        }

        sb.append(" (Distancia: ").append(distancia).append(")");
        sb.append("\n"); // Añadir salto de línea al final
        return sb.toString();
    }

    public void setDistancia(double d) {
        this.distancia = d;
    }

    public void clear() {
        resultado.clear();
        distancia = Double.POSITIVE_INFINITY;
    }

}