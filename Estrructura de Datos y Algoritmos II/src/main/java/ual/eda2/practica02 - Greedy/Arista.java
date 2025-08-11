package ual.eda2.practica02;

import java.util.Objects;

/**
 * Representa una arista en un grafo, que conecta dos vértices con un peso asociado.
 * Esta clase es utilizada para registrar las aristas exploradas durante la ejecución
 * de algoritmos de búsqueda de caminos mínimos.
 */
public class Arista {
    private Vertice origen;
    private Vertice destino;
    private double peso;

    /**
     * Constructor para crear una nueva arista entre dos vértices.
     *
     * @param origen El vértice de origen de la arista
     * @param destino El vértice de destino de la arista
     * @param peso El peso o costo asociado al recorrido de esta arista
     */
    public Arista(Vertice origen, Vertice destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Obtiene el vértice de origen de la arista.
     *
     * @return El vértice desde el cual parte la arista
     */
    public Vertice getOrigen() {
        return origen;
    }

    /**
     * Obtiene el vértice de destino de la arista.
     *
     * @return El vértice hacia el cual se dirige la arista
     */
    public Vertice getDestino() {
        return destino;
    }

    /**
     * Obtiene el peso o costo asociado a esta arista.
     *
     * @return El valor numérico que representa el peso de la arista
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Compara esta arista con otro objeto para determinar si son iguales.
     * Dos aristas se consideran iguales si conectan los mismos vértices,
     * independientemente de la dirección (el grafo se considera no dirigido).
     *
     * @param obj El objeto a comparar con esta arista
     * @return true si las aristas conectan los mismos vértices, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Arista arista = (Arista) obj;
        // Compara origen y destino de forma bidireccional
        return (origen.equals(arista.origen) && destino.equals(arista.destino)) ||
                (origen.equals(arista.destino) && destino.equals(arista.origen));
    }

    /**
     * Genera un valor hash para esta arista basado en los vértices que conecta.
     * El hash se calcula de forma que sea consistente con el método equals,
     * asegurando que aristas entre los mismos vértices tengan el mismo hash
     * independientemente de la dirección.
     *
     * @return Un valor hash para esta arista
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                Math.min(origen.hashCode(), destino.hashCode()),
                Math.max(origen.hashCode(), destino.hashCode()));
    }

    /**
     * Devuelve una representación en cadena de texto de esta arista.
     *
     * @return Una cadena con la información de origen, destino y peso de la arista
     */
    @Override
    public String toString() {
        return "Arista{" +
                "origen=" + origen.getIdentificador() +
                ", destino=" + destino.getIdentificador() +
                ", peso=" + peso +
                '}';
    }
}
