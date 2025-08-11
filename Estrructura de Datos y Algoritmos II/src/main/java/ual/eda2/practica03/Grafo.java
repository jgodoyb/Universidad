package ual.eda2.practica03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {

    private Vertice origen, destino;
    private boolean dirigido;
    private Map<Vertice, Map<Vertice, Double>> mapa;

    public Grafo(Vertice origen, Vertice destino, boolean dirigido) {
        this.origen = origen;
        this.destino = destino;
        this.dirigido = dirigido;
        this.mapa = new HashMap<>();
    }

    public Grafo(Vertice origen, Vertice destino) {
        this(origen, destino, false);
    }

    public Grafo() {
        this.origen = null;
        this.destino = null;
        this.dirigido = false;
        this.mapa = new HashMap<>();
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void addVertice(Vertice vertice) {
        if (!mapa.containsKey(vertice)) {
            mapa.put(vertice, new HashMap<>());
        }
    }

    public void addVertice(String nombre) {
        addVertice(new Vertice(nombre));
    }

    public void addArista(Vertice v1, Vertice v2, double peso) {
        addVertice(v1);
        addVertice(v2);
        mapa.get(v1).put(v2, peso);
        if (!dirigido) {
            mapa.get(v2).put(v1, peso);
        }
    }

    public void addArista(String origen, String destino, double peso) {
        addArista(new Vertice(origen), new Vertice(destino), peso);
    }

    public Double getPeso(Vertice v1, Vertice v2) {
        Map<Vertice, Double> aristas = mapa.get(v1);
        if (aristas != null) {
            return aristas.get(v2);
        }
        return null;
    }

    public Set<Vertice> getVecinos(Vertice vertice) {
        return mapa.get(vertice).keySet();
    }

    public int size() {
        return mapa.size();
    }

    public double[][] mapaMatriz() {
        double[][] matriz = new double[size()][size()];
        int i = 0;
        for (Vertice v1 : mapa.keySet()) {
            int j = 0;
            for (Vertice v2 : mapa.keySet()) {
                Double peso = getPeso(v1, v2);
                if (peso != null) {
                    matriz[i][j] = peso;
                } else {
                    matriz[i][j] = Double.POSITIVE_INFINITY;
                }
                j++;
            }
            i++;
        }
        return matriz;
    }

    public Vertice[] asociarIndexVertices() {
        Vertice[] vertices = new Vertice[mapa.size()];
        int i = 0;
        for (Vertice vertice : mapa.keySet()) {
            vertices[i] = vertice;
            i++;
        }
        return vertices;
    }

    public List<Vertice> obtenerListaVertices(Integer[] indices) {
        Vertice[] vertices = asociarIndexVertices();
        List<Vertice> listaVertices = new LinkedList<>();
        for (Integer indice : indices) {
            listaVertices.add(vertices[indice]);
        }

        return listaVertices;
    }

    public Integer getVertexIndex(Vertice vertice) {
        Vertice[] vertices = asociarIndexVertices();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return null;
    }

    public boolean contieneVertice(Vertice vertice) {
        return mapa.containsKey(vertice);
    }

    public Set<Vertice> getVertices() {
        return mapa.keySet();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertice v1 : mapa.keySet()) {
            sb.append(v1.getNombre()).append(": ");
            for (Map.Entry<Vertice, Double> entry : mapa.get(v1).entrySet()) {
                sb.append(entry.getKey().getNombre()).append(" (").append(entry.getValue()).append("), ");
            }
            sb.delete(sb.length() - 2, sb.length()); // Eliminar la última coma y espacio
            sb.append("\n");
        }
        return sb.toString();
    }

    public void setDirigido(boolean b) {
        this.dirigido = b;
    }

}
