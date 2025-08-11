package ual.eda2.practica02;

import java.util.LinkedList;

/**
 * Representa un camino entre dos vértices en un grafo.
 * Esta clase almacena información sobre el origen, destino, distancia total,
 * la secuencia de vértices que conforman el camino y el número de aristas
 * exploradas durante la ejecución del algoritmo que encontró este camino.
 */
public class Camino {

    private Vertice origen;
    private Vertice destino;
    private Double distancia;
    private LinkedList<Vertice> camino;
    public int numAristasExploradas;

    /**
     * Constructor que crea un camino a partir de los resultados de un algoritmo de
     * Dijkstra.
     * Establece el número de aristas exploradas a cero.
     * 
     * @param dijkstraResult Mapa con los resultados del algoritmo de Dijkstra
     * @param origen         Vértice de origen del camino
     * @param destino        Vértice de destino del camino
     */
    public Camino(CustomMap dijkstraResult, Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = dijkstraResult.getDistancia(destino);
        this.camino = distancia == Double.MAX_VALUE ? null : getCamino(dijkstraResult);
        this.numAristasExploradas = 0; // Valor predeterminado
    }

    /**
     * Constructor que crea un camino a partir de los resultados de un algoritmo de
     * Dijkstra
     * y especifica el número de aristas exploradas.
     * 
     * @param dijkstraResult       Mapa con los resultados del algoritmo de Dijkstra
     * @param origen               Vértice de origen del camino
     * @param destino              Vértice de destino del camino
     * @param numAristasExploradas Número de aristas exploradas durante la ejecución
     *                             del algoritmo
     */
    public Camino(CustomMap dijkstraResult, Vertice origen, Vertice destino, int numAristasExploradas) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = dijkstraResult.getDistancia(destino);
        this.camino = distancia == Double.MAX_VALUE ? null : getCamino(dijkstraResult);
        this.numAristasExploradas = numAristasExploradas; // Asignamos el valor recibido
    }

    /**
     * Constructor que crea un camino con valores específicos para cada atributo.
     * Establece el número de aristas exploradas a cero.
     * 
     * @param origen    Vértice de origen del camino
     * @param destino   Vértice de destino del camino
     * @param distancia Distancia total del camino
     * @param camino    Lista de vértices que conforman el camino
     */
    public Camino(Vertice origen, Vertice destino, double distancia, LinkedList<Vertice> camino) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.camino = camino;
        this.numAristasExploradas = 0; // Valor predeterminado
    }

    /**
     * Constructor que crea un camino con valores específicos para cada atributo
     * incluyendo el número de aristas exploradas.
     * 
     * @param origen               Vértice de origen del camino
     * @param destino              Vértice de destino del camino
     * @param distancia            Distancia total del camino
     * @param camino               Lista de vértices que conforman el camino
     * @param numAristasExploradas Número de aristas exploradas durante la ejecución
     *                             del algoritmo
     */
    public Camino(Vertice origen, Vertice destino, double distancia, LinkedList<Vertice> camino,
            int numAristasExploradas) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.camino = camino;
        this.numAristasExploradas = numAristasExploradas;
    }

    /**
     * Construye la secuencia de vértices que conforman el camino a partir de
     * los predecesores calculados por un algoritmo de búsqueda de caminos.
     *
     * @param dijkstraResult Mapa con los resultados que incluyen los predecesores
     *                       de cada vértice
     * @return Una lista enlazada con los vértices en el orden que forman el camino
     *         desde el origen hasta el destino
     */
    public LinkedList<Vertice> getCamino(CustomMap dijkstraResult) {
        LinkedList<Vertice> camino = new LinkedList<Vertice>();
        Vertice actual = destino;
        while (!actual.equals(origen)) {
            camino.addFirst(actual);
            actual = dijkstraResult.getPredecesor(actual);
        }
        return camino;
    }

    /**
     * Obtiene la distancia total del camino.
     *
     * @return La distancia calculada para este camino, o Double.MAX_VALUE si no
     *         existe camino
     */
    public Double getDistancia() {
        return distancia;
    }

    /**
     * Obtiene el número de aristas exploradas durante la ejecución del algoritmo
     * que encontró este camino.
     *
     * @return El número de aristas exploradas
     */
    public int getAristasExploradas() {
        return numAristasExploradas;
    }

    /**
     * Devuelve una representación en cadena de texto de este camino.
     * Incluye la distancia total y la secuencia de vértices desde el origen hasta
     * el destino.
     *
     * @return Una cadena que representa el camino
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distancia: " + distancia + "\n");
        sb.append("Camino: " + origen.getIdentificador() + " > ");
        if (camino == null) {
            sb.append("No hay camino disponible");
        } else {
            for (Vertice vertice : camino) {
                sb.append(vertice.getIdentificador() + " > ");
            }
        }
        return sb.toString().substring(0, sb.length() - 3);
    }
}
