package ual.eda2.practica02;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Implementación de diversos algoritmos para encontrar caminos mínimos en
 * grafos.
 * Esta clase proporciona múltiples variantes del algoritmo de Dijkstra, A* y
 * otros algoritmos para resolver problemas de caminos óptimos en grafos.
 */
public class Algoritmos {

    /**
     * Implementación base del algoritmo de Dijkstra para encontrar el camino más
     * corto entre dos vértices.
     * 
     * @param net     Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraV1(Network<Vertice> net, Vertice origen, Vertice destino) {
        if (!net.containsVertice(origen))
            throw new IllegalArgumentException("El vertice de destino no se encuentra en el grafo");
        if (!net.containsVertice(destino))
            throw new IllegalArgumentException("El vertice de destino no se encuentra en el grafo");

        // HashSet de aristas añadir una clase aristar, para las aristas que vas
        // explorando luego representarlas
        HashSet<Arista> aristasExploradas = new HashSet<>(); // Conjunto de aristas exploradas
        CustomMap dp = new CustomMap();
        HashSet<Vertice> restantes = new HashSet<>(net.verticeSet());// Conjunto de vértices restantes
        restantes.remove(origen);

        for (Vertice v : restantes) {
            double distancia = net.getWeight(origen, v);
            if (distancia != -1)
                dp.add(v, origen, distancia);
            else
                dp.add(v, null, Double.MAX_VALUE);
        }

        dp.add(origen, origen, 0.0);

        while (!restantes.isEmpty()) {
            Vertice u = dp.getVerticeMenorDistancia(restantes);
            if (u == null)
                break;
            if (u.equals(destino))
                break;

            restantes.remove(u);

            for (Vertice v : restantes) {
                double peso = net.getWeight(u, v);
                if (peso != -1) {
                    double nuevaDistancia = dp.getDistancia(u) + peso;
                    Arista arista = new Arista(u, v, peso);
                    aristasExploradas.add(arista);
                    if (nuevaDistancia < dp.getDistancia(v))
                        dp.add(v, u, nuevaDistancia);
                }
            }
        }
        int numAristasExploradas = aristasExploradas.size();
        Camino camino = new Camino(dp, origen, destino, numAristasExploradas); // Añadir contador y hashmap al
                                                                               // constructor de camino
        return camino;
    }

    /**
     * Implementación simple (naive) del algoritmo de Dijkstra para encontrar el
     * camino más
     * corto entre dos vértices. Esta versión explora sólo los vecinos directos de
     * cada vértice.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraNaive(Network<Vertice> g, Vertice origen, Vertice destino) {
        if (!g.containsVertice(origen) || !g.containsVertice(destino))
            throw new IllegalArgumentException("El vertice de origen no se encuentra en el grafo");

        HashSet<Arista> aristasExploradas = new HashSet<>();
        CustomMap dp = new CustomMap();
        HashSet<Vertice> restantes = new HashSet<>(g.verticeSet());
        restantes.remove(origen);

        for (Vertice v : restantes) {
            double peso = g.getWeight(origen, v);
            if (peso != -1)
                dp.add(v, origen, peso);
            else
                dp.add(v, null, Double.MAX_VALUE);
        }

        dp.add(origen, origen, 0.0);

        while (!restantes.isEmpty()) {
            Vertice u = dp.getVerticeMenorDistancia(restantes);
            if (u == null)
                break;
            if (u == destino)
                break;

            restantes.remove(u);

            for (Vertice v : g.getNeighbors(u)) {
                double peso = g.getWeight(u, v);
                double nuevaDistancia = dp.getDistancia(u) + peso;
                Arista arista = new Arista(u, v, peso);
                aristasExploradas.add(arista);
                if (nuevaDistancia < dp.getDistancia(v))
                    dp.add(v, u, nuevaDistancia);

            }
        }
        int numAristasExploradas = aristasExploradas.size();
        System.out.println("Aristas exploradas: " + numAristasExploradas);
        Camino camino = new Camino(dp, origen, destino, numAristasExploradas); // Añadir contador y hashmap al
                                                                               // constructor de camino
        return camino;
    }

    /**
     * Implementación del algoritmo de Dijkstra utilizando una cola de prioridad
     * para
     * optimizar la selección del siguiente vértice a explorar.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraPQ(Network<Vertice> g, Vertice origen, Vertice destino) {
        if (!g.containsVertice(origen) || !g.containsVertice(destino))
            throw new IllegalArgumentException("El vertice de origen no se encuentra en el grafo");

        CustomMap dp = new CustomMap();
        PriorityQueue<Par<Vertice, Double>> colaPrioridad = new PriorityQueue<>();
        HashSet<Vertice> visitados = new HashSet<>();

        for (Vertice v : g.verticeSet()) {
            dp.add(v, null, Double.MAX_VALUE);
        }

        dp.add(origen, origen, 0.0);
        colaPrioridad.add(new Par<>(origen, 0.0));

        while (!colaPrioridad.isEmpty()) {
            Par<Vertice, Double> actual = colaPrioridad.poll();// Extraer el vértice con menor distancia, y lo elimina
                                                               // de la cola de prioridad
            Vertice from = actual.getClave();// Estamos guardando el vértice actual

            if (from.equals(destino))
                break;
            if (visitados.contains(from))
                continue;

            visitados.add(from);

            for (Vertice to : g.getNeighbors(from)) {
                Double peso = g.getWeight(from, to);
                if (!visitados.contains(to)) {
                    double nuevaDistancia = dp.getDistancia(from) + peso;
                    if (nuevaDistancia < dp.getDistancia(to)) {
                        dp.add(to, from, nuevaDistancia);
                        colaPrioridad.add(new Par<>(to, nuevaDistancia));

                    }
                }
            }
        }
        int numAristasExploradas = 0;

        Camino camino = new Camino(dp, origen, destino, numAristasExploradas);
        return camino;
    }

    /**
     * Implementación del algoritmo Best-First de Dijkstra que utiliza una cola de
     * prioridad
     * para explorar primero los vértices más prometedores.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraBestFirst(Network<Vertice> g, Vertice origen, Vertice destino) {
        if (!g.containsVertice(origen) || !g.containsVertice(destino))
            throw new IllegalArgumentException("El vertice de origen no se encuentra en el grafo");

        HashSet<Arista> aristasExploradas = new HashSet<>();
        CustomMap dp = new CustomMap();
        PriorityQueue<Triple<Vertice, Double, Vertice>> colaPrioridad = new PriorityQueue<>();

        for (Vertice v : g.verticeSet()) {
            dp.add(v, null, Double.MAX_VALUE);
        }

        dp.add(origen, origen, 0.0);
        colaPrioridad.add(new Triple<>(origen, 0.0, origen));

        while (!colaPrioridad.isEmpty()) {
            Triple<Vertice, Double, Vertice> actual = colaPrioridad.poll();
            Vertice to = actual.getDestino();
            double peso = dp.getDistancia(to);
            Vertice from = actual.getClave();

            if (to.equals(destino))
                break;
            if (peso < actual.getValor())
                continue;

            dp.add(to, from, peso);

            for (Vertice v : g.getNeighbors(to)) {
                Double nuevaDistancia = g.getWeight(to, v) + peso;
                if (nuevaDistancia < dp.getDistancia(v)) {
                    dp.add(v, to, nuevaDistancia);
                    colaPrioridad.add(new Triple<Vertice, Double, Vertice>(v, nuevaDistancia, to));
                }
            }
        }
        int numAristasExploradas = aristasExploradas.size();
        System.out.println("Aristas exploradas: " + numAristasExploradas);
        Camino camino = new Camino(dp, origen, destino, numAristasExploradas);
        return camino;
    }

    /**
     * Implementación del algoritmo A* (A-Star) que utiliza una heurística para
     * guiar
     * la búsqueda hacia el destino de manera más eficiente.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino aStar(Network<Vertice> g, Vertice origen, Vertice destino) {
        if (!g.containsVertice(origen) || !g.containsVertice(destino))
            throw new IllegalArgumentException("El vertice de origen no se encuentra en el grafo");

        PriorityQueue<Vertice> openList = new PriorityQueue<>();
        HashSet<Vertice> closedList = new HashSet<>();

        for (Vertice v : g.verticeSet()) {
            v.setCosteAcumulado(Double.MAX_VALUE); // Valor alto inicialmente //Es la g
            v.setSumaCosteHeuristica(Double.MAX_VALUE); // Debería ser actualizado después // Es la f
            v.setAnterior(null); // Sin predecesor // No hay camino conocido
        }

        origen.setCosteAcumulado(0.0);//g(n)
        origen.setSumaCosteHeuristica(origen.getCosteAcumulado() + origen.heuristicaDistanciaEuclidea(destino)); //f(n)

        openList.add(origen);
        

        while (!openList.isEmpty()) {
            Vertice actual = openList.poll();

            if (actual.equals(destino)) {
                LinkedList<Vertice> camino = new LinkedList<>();
                double distanciaTotal = 0.0;
                while (actual != null) {
                    camino.addFirst(actual);
                    if (actual.getAnterior() != null) {
                        distanciaTotal += g.getWeight(actual.getAnterior(), actual);
                    }
                    actual = actual.getAnterior();
                }

                return new Camino(origen, destino, distanciaTotal, camino, 0);
            }

            closedList.add(actual);

            for (Vertice vecino : g.getNeighbors(actual)) {
                if (closedList.contains(vecino))
                    continue;

                double tentativeG = actual.getCosteAcumulado() + g.getWeight(actual, vecino);

                if (tentativeG < vecino.getCosteAcumulado()) {
                    vecino.setCosteAcumulado(tentativeG);
                    vecino.setSumaCosteHeuristica(vecino.getCosteAcumulado() + vecino.heuristicaDistanciaEuclidea(destino));
                    vecino.setAnterior(actual);
                    openList.remove(vecino);
                    openList.add(vecino);
                }
            }

        }
        LinkedList<Vertice> camino = new LinkedList<>();
        Camino solucion = new Camino(origen, destino, Double.MAX_VALUE, camino, 0);
        return solucion;
    }

    /**
     * Implementación híbrida entre Dijkstra y A* que combina la garantía de
     * encontrar
     * el camino óptimo de Dijkstra con la eficiencia de A* mediante el uso de
     * heurísticas.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta más corta y su distancia
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraAStar(Network<Vertice> g, Vertice origen, Vertice destino) {
        if (!g.containsVertice(origen)) {
            throw new IllegalArgumentException("El vértice de origen no está en el grafo");
        }
        if (!g.containsVertice(destino)) {
            throw new IllegalArgumentException("El vértice de destino no está en el grafo");
        }

        CustomMap dp = new CustomMap();
        PriorityQueue<Triple<Vertice, Double, Vertice>> pq = new PriorityQueue<>();

        for (Vertice v : g.verticeSet()) {
            dp.add(v, null, Double.MAX_VALUE);
        }
        dp.add(origen, origen, 0.0);

        pq.add(new Triple<>(origen, origen.heuristicaDistanciaEuclidea(destino), origen));

        while (!pq.isEmpty()) {
            Triple<Vertice, Double, Vertice> actual = pq.poll();
            Vertice to = actual.getDestino();
            double fvalue = actual.getValor();
            Vertice from = actual.getClave();

            if (to.equals(destino)) {
                break;
            }

            double gvalue = dp.getDistancia(to);

            if (fvalue > gvalue + to.heuristicaDistanciaEuclidea(destino)) {
                continue;
            }

            dp.add(to, from, gvalue);

            for (Vertice vecino : g.getNeighbors(to)) {
                double w = g.getWeight(to, vecino);
                if (w != -1) {
                    double tentativeG = gvalue + w;
                    double newF = tentativeG + vecino.heuristicaDistanciaEuclidea(destino);

                    if (tentativeG < dp.getDistancia(vecino)) {
                        dp.add(vecino, to, tentativeG);
                        pq.add(new Triple<>(vecino, newF, to));
                    }
                }
            }
        }
        return new Camino(dp, origen, destino, 0);
    }

    /**
     * Algoritmo de Dijkstra Best-First adaptado para resolver el problema del
     * camino de máximo ancho de banda (Widest Path Problem). En lugar de minimizar
     * la distancia total, busca maximizar el ancho de banda mínimo a lo largo del
     * camino.
     * 
     * @param g       Red o grafo en el que se busca el camino
     * @param origen  Vértice desde el cual comienza la búsqueda
     * @param destino Vértice al cual se desea llegar
     * @return Un objeto Camino que contiene la ruta con mayor ancho de banda mínimo
     * @throws IllegalArgumentException Si alguno de los vértices no se encuentra en
     *                                  el grafo
     */
    public static Camino dijkstraBestFirstWPP(Network<Vertice> g, Vertice origen, Vertice destino) {
        // Verificación de parámetros
        if (!g.containsVertice(origen))
            throw new IllegalArgumentException("El vértice de origen no está en el grafo");
        if (!g.containsVertice(destino))
            throw new IllegalArgumentException("El vértice de destino no está en el grafo");

        // Para registro de aristas exploradas
        HashSet<Arista> aristasExploradas = new HashSet<>();

        // Mapa para almacenar predecesores y anchos de banda máximos
        CustomMap dp = new CustomMap();

        // Cola de prioridad en orden descendente (máximo primero)
        PriorityQueue<Triple<Vertice, Double, Vertice>> pq = new PriorityQueue<>(new TripleComparator().reversed());

        // Inicializar todos los vértices con ancho de banda -∞
        for (Vertice v : g.verticeSet()) {
            dp.add(v, null, Double.NEGATIVE_INFINITY);
        }

        // El origen tiene ancho de banda infinito hacia sí mismo
        dp.add(origen, origen, Double.POSITIVE_INFINITY);
        pq.add(new Triple<>(origen, Double.POSITIVE_INFINITY, origen));

        // Bucle principal
        while (!pq.isEmpty()) {
            Triple<Vertice, Double, Vertice> current = pq.poll();
            Vertice to = current.getDestino();
            double currentWidth = current.getValor();
            Vertice from = current.getClave();

            // Si llegamos al destino, terminamos
            if (to.equals(destino))
                break;

            // Si el ancho de banda actual es menor que el mejor conocido, ignoramos
            if (currentWidth < dp.getDistancia(to))
                continue;

            // Actualizar el mejor ancho de banda y predecesor
            dp.add(to, from, currentWidth);

            // Explorar vecinos
            for (Vertice vecino : g.getNeighbors(to)) {
                double peso = g.getWeight(to, vecino);
                if (!Double.isNaN(peso)) {
                    // El ancho de banda del camino es el mínimo entre el ancho actual
                    // y el peso de la nueva arista, pero queremos maximizar este valor
                    double newWidth = Math.min(currentWidth, peso);

                    // Si encontramos un mejor ancho de banda para este vecino
                    if (newWidth > dp.getDistancia(vecino)) {
                        dp.add(vecino, to, newWidth);
                        pq.add(new Triple<>(vecino, newWidth, to));

                        // Registrar la arista explorada
                        Arista arista = new Arista(to, vecino, peso);
                        aristasExploradas.add(arista);
                    }
                }
            }
        }

        // Construcción del camino resultante
        LinkedList<Vertice> camino = new LinkedList<>();
        Vertice actual = destino;
        double bottleneck = Double.POSITIVE_INFINITY;

        // Reconstruir el camino desde el destino al origen
        while (!actual.equals(origen)) {
            Vertice padre = dp.getPredecesor(actual);
            if (padre == null)
                return null; // No hay camino válido

            double pesoArista = g.getWeight(padre, actual);
            bottleneck = Math.min(bottleneck, pesoArista);
            camino.addFirst(actual);
            actual = padre;
        }

        // Añadir el origen al principio del camino
        camino.addFirst(origen);

        // Registrar estadísticas y devolver resultado
        int numAristasExploradas = aristasExploradas.size();
        System.out.println("Aristas exploradas: " + numAristasExploradas);
        return new Camino(origen, destino, bottleneck, camino, numAristasExploradas);
    }

}
