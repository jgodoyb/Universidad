package ual.eda2.practica02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomMap {

    private Map<Vertice, Par<Vertice, Double>> mapa;

    /**
     * Constructor de la clase DatosCaminos.
     * Inicializa un mapa vacío que almacenará los vértices y sus respectivas
     * distancias mínimas.
     */
    public CustomMap() {
        this.mapa = new HashMap<Vertice, Par<Vertice, Double>>();
    }

    public Map<Vertice, Par<Vertice, Double>> getMapa() {
        return this.mapa;
    }

    public void setMapa(Map<Vertice, Par<Vertice, Double>> mapa) {
        this.mapa = mapa;
    }

    public void add(Vertice actual, Vertice predecesor, Double distanciaMinima) {
        mapa.put(actual, new Par<Vertice, Double>(predecesor, distanciaMinima));
    }

    public boolean contains(Vertice vertice) {
        return mapa.containsKey(vertice);
    }

    public Set<Vertice> getDistConjunto() {
        return mapa.keySet();
    }

    public Double getDistancia(Vertice vertice) {
        Par<Vertice, Double> par = mapa.get(vertice);
        return par == null ? null : par.getValor();
    }

    public Vertice getPredecesor(Vertice v) {
        Par<Vertice, Double> par = mapa.get(v);
        return par == null ? null : par.getClave();
    }

    public Vertice getVerticeMenorDistancia(Set<Vertice> remaining) {
        Vertice minVertice = null;
        Double minDist = Double.MAX_VALUE;

        for (Vertice vertice : remaining) {
            Double dist = getDistancia(vertice);
            if (dist != null && dist < minDist) {
                minVertice = vertice;
                minDist = dist;
            }
        }
        return minVertice;
    }

}
