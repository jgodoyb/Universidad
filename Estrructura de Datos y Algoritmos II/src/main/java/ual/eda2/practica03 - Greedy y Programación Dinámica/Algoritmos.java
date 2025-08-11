package ual.eda2.practica03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Algoritmos {
    /**
     * Encuentra todos los caminos simples desde un vértice de origen a todos sus
     * vecinos.
     *
     * @param g      El grafo en el que se buscan los caminos.
     * @param origen El vértice de origen desde el cual se inician los caminos.
     * @return Una lista de soluciones que contienen los caminos simples
     *         encontrados.
     */
    public static List<Solucion> simplePaths(Grafo g, Vertice origen) {
        Solucion ruta = new Solucion();
        LinkedList<Solucion> soluciones = new LinkedList<>();
        HashSet<Vertice> visitados = new HashSet<>();

        for (Vertice destino : g.getVecinos(origen)) {
            simplePathsAux(origen, destino, g, ruta, visitados, soluciones);
        }

        return soluciones;
    }

    /**
     * Método auxiliar recursivo para encontrar todos los caminos simples entre dos
     * vértices.
     *
     * @param actual     El vértice actual en el recorrido.
     * @param destino    El vértice de destino al que se quiere llegar.
     * @param g          El grafo en el que se buscan los caminos.
     * @param ruta  La solución parcial que se está construyendo.
     * @param visitados  Conjunto de vértices ya visitados en el recorrido actual.
     * @param soluciones Lista de soluciones que contiene todos los caminos
     *                   encontrados.
     */
    public static void simplePathsAux(Vertice actual, Vertice destino, Grafo g, Solucion ruta,
            HashSet<Vertice> visitados, List<Solucion> soluciones) {

        ruta.addVertice(actual);
        visitados.add(actual);

        if (actual.equals(destino) && ruta.size() == g.size()) {
            ruta.addVertice(ruta.get(0));
            double suma = 0;
            for (int i = 0; i < ruta.size() - 1; i++) {
                suma += g.getPeso(ruta.get(i), ruta.get(i + 1));
            }
            soluciones.add(new Solucion(ruta.getResultado(), suma));
            ruta.removeLast();
        }

        for (Vertice v : g.getVecinos(actual)) {
            if (!visitados.contains(v)) {
                simplePathsAux(v, destino, g, ruta, visitados, soluciones);
            }
        }

        visitados.remove(actual);
        ruta.removeLast();
    }

    /**
     * Encuentra el camino más corto que visita todos los vértices del grafo
     * exactamente una vez
     * y regresa al vértice de origen utilizando caminos simples.
     *
     * @param g      El grafo en el que se busca el camino.
     * @param origen El vértice de origen desde el cual se inicia el recorrido.
     * @return La solución que contiene el camino más corto y su distancia.
     */
    public static Solucion tspSimplePaths(Grafo g, Vertice origen) {
        Solucion ruta = new Solucion();
        Solucion solucion = new Solucion();
        HashSet<Vertice> visitados = new HashSet<>();

        for (Vertice destino : g.getVecinos(origen)) {
            tspSimplePathsAux(origen, destino, g, ruta, visitados, solucion);
        }
        return solucion;
    }

    /**
     * Método auxiliar recursivo para encontrar el camino más corto que visita todos
     * los vértices.
     *
     * @param actual    El vértice actual en el recorrido.
     * @param destino   El vértice de destino al que se quiere llegar.
     * @param g         El grafo en el que se buscan los caminos.
     * @param ruta La solución parcial que se está construyendo.
     * @param visitados Conjunto de vértices ya visitados en el recorrido actual.
     * @param solucion  La solución óptima encontrada hasta el momento.
     */
    private static void tspSimplePathsAux(Vertice actual, Vertice destino, Grafo g, Solucion ruta,
            HashSet<Vertice> visitados, Solucion solucion) {

        ruta.addVertice(actual);
        visitados.add(actual);

        if (actual.equals(destino) && ruta.size() == g.size()) {
            ruta.addVertice(ruta.get(0));
            double suma = 0;
            for (int i = 0; i < ruta.size() - 1; i++) {
                suma += g.getPeso(ruta.get(i), ruta.get(i + 1));
            }
            if (suma < solucion.getDistancia()) {
                solucion.clear();
                solucion.setDistancia(suma);
                for (Vertice vertice : ruta.getResultado()) {
                    solucion.addVertice(vertice);
                }
            }
            ruta.removeLast();
        }

        for (Vertice v : g.getVecinos(actual)) {
            if (!visitados.contains(v)) {
                tspSimplePathsAux(v, destino, g, ruta, visitados, solucion);
            }
        }

        ruta.removeLast();
        visitados.remove(actual);

    }

    /**
     * Resuelve el problema del viajero (TSP) utilizando fuerza bruta.
     * 
     * @param g      El grafo completo representado como una matriz de adyacencia.
     * @param origen El vértice de inicio desde el cual se inicia la búsqueda.
     * @return La solución óptima encontrada para el TSP.
     */
    public static Solucion tspBruteForce(Grafo g, Vertice origen) {
        Solucion mejorSolucion = null;
        double[][] matriz = g.mapaMatriz();
        int startNode = g.getVertexIndex(origen);
        int n = g.size();

        Integer[] permutacion = new Integer[n - 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == startNode)
                continue;
            permutacion[j] = i;
            j++;
        }

        Integer[] mejorRuta = null;
        double mejorCosto = Double.POSITIVE_INFINITY;

        do {
            double costo = calcularCosto(startNode, permutacion, matriz);
            if (costo < mejorCosto) {
                mejorCosto = costo;
                mejorRuta = permutacion.clone(); 
            }
        } while (siguientePermutacion(permutacion));

        List<Vertice> vertices = g.obtenerListaVertices(mejorRuta);
        vertices.add(vertices.get(0)); 
        mejorSolucion = new Solucion(vertices, mejorCosto);

        return mejorSolucion;
    }

    /**
     * Genera la siguiente permutación lexicográfica de una secuencia de enteros.
     * 
     * @param secuencia La secuencia de enteros a permutar.
     * @return true si se generó una nueva permutación, false si no hay más
     *         permutaciones posibles.
     */
    private static boolean siguientePermutacion(Integer[] secuencia) {
        int primero = obtenerPrimerIndice(secuencia);
        if (primero == -1) {
            return false;
        }

        int toSwap = secuencia.length - 1;
        while (secuencia[toSwap] <= secuencia[primero]) {
            toSwap--;
        }
        swap(secuencia, primero, toSwap);
        primero++;
        toSwap = secuencia.length - 1;

        while (primero < toSwap) {
            swap(secuencia, primero, toSwap);
            primero++;
            toSwap--;
        }

        return true;
    }

    /**
     * Encuentra el primer índice donde la secuencia deja de ser creciente.
     * 
     * @param secuencia La secuencia de enteros a analizar.
     * @return El índice del primer elemento que es menor que su siguiente, o -1 si
     *         no hay más permutaciones posibles.
     */
    private static int obtenerPrimerIndice(Integer[] secuencia) {
        for (int i = secuencia.length - 2; i >= 0; i--) {
            if (secuencia[i] < secuencia[i + 1]) {
                return i;
            }
        }
        return -1; 
    }

    /**
     * Intercambia dos elementos en una secuencia de enteros.
     * 
     * @param secuencia La secuencia de enteros en la que se realizará el
     *                  intercambio.
     * @param primero   El índice del primer elemento a intercambiar.
     * @param toSwap    El índice del segundo elemento a intercambiar.
     */
    private static void swap(Integer[] secuencia, int primero, int toSwap) {
        int temp = secuencia[primero];
        secuencia[primero] = secuencia[toSwap];
        secuencia[toSwap] = temp;
    }

    /**
     * Calcula el costo total de una ruta dada en un grafo.
     * 
     * @param origen El índice del vértice de origen.
     * @param ruta   La ruta representada como un arreglo de índices de vértices.
     * @param matriz La matriz de distancias entre los vértices del grafo.
     * @return El costo total de la ruta.
     */
    private static double calcularCosto(Integer origen, Integer[] ruta, double[][] matriz) { 
        double coste = 0;
        coste += matriz[origen][ruta[0]];

        for (int i = 0; i < ruta.length - 1; i++) {
            int desde = ruta[i];
            int hasta = ruta[i + 1];
            coste += matriz[desde][hasta];
        }
        int ultimo = ruta[ruta.length - 1]; 
        int primero = origen; 
        coste += matriz[ultimo][primero];
        return coste;
    }

    /**
     * Resuelve el Problema del Viajante (TSP) utilizando un enfoque recursivo.
     *
     * @param g     El grafo que representa el problema, donde los vértices son ciudades y las aristas son distancias.
     * @param start El vértice inicial para el recorrido del TSP.
     * @return Un objeto {@link Solucion} que contiene el recorrido óptimo (lista de vértices) y su coste.
     *
     * El método calcula el recorrido de coste mínimo que visita todos los vértices exactamente una vez y regresa al vértice inicial.
     * Utiliza una función auxiliar recursiva con memorización para calcular la solución óptima.
     * La solución incluye:
     * - El coste mínimo del recorrido.
     * - La secuencia de vértices que representa el recorrido óptimo.
     *
     * Precondiciones:
     * - El grafo debe estar completamente conectado.
     * - El grafo debe tener al menos un vértice.
     *
     * Postcondiciones:
     * - La solución devuelta contiene un recorrido válido para el TSP y su coste.
     */
    public static Solucion tspRecursive(Grafo g, Vertice start) {
        Solucion sol = null;
        int startNode = g.getVertexIndex(start);
        double[][] distance = g.mapaMatriz();
        List<Integer> tour = new ArrayList<>();
        double minTourCost = Double.POSITIVE_INFINITY;
        int state = 1 << startNode;
        int N = distance.length;
        Double[][] memo = new Double[N][1 << N];
        Integer[][] prev = new Integer[N][1 << N];
        minTourCost = tspRecursiveAux(startNode, state, memo, prev, distance, startNode);
        int index = startNode;

        while (true) {
            tour.add(index);
            Integer nextIndex = prev[index][state];
            if (nextIndex == null)
                break;
            int nextState = state | (1 << nextIndex);
            state = nextState;
            index = nextIndex;
        }
        tour.add(startNode);
        List<Vertice> vertexes = g.obtenerListaVertices(tour.toArray(new Integer[tour.size()]));
        sol = new Solucion(vertexes, minTourCost);
        return sol;
    }

    /**
     * Función recursiva que calcula el coste mínimo del TSP utilizando
     * programación dinámica y memorización.
     * 
     * @param i         El índice del nodo actual.
     * @param state     El estado actual representando los nodos visitados.
     * @param memo      La tabla de memorización para evitar cálculos repetidos.
     * @param prev      La tabla para reconstrucción del camino óptimo.
     * @param distance  La matriz de distancias entre los nodos.
     * @param startNode El índice del nodo inicial.
     * @return El coste mínimo del recorrido desde el nodo actual al resto de nodos.
     */
    private static double tspRecursiveAux(int i, int state, Double[][] memo, Integer[][] prev, double[][] distance, int startNode) {
        int N = distance.length;
        int FINISHED_STATE = (1 << N) - 1;
    
        if (state == FINISHED_STATE) {
            return distance[i][startNode];
        }
    
        if (memo[i][state] != null) {
            return memo[i][state];
        }
    
        double minCost = Double.POSITIVE_INFINITY;
        int index = -1;
    
        for (int next = 0; next < N; next++) {
            if ((state & (1 << next)) != 0) {
                continue;
            }
    
            int nextState = state | (1 << next);
            double newCost = distance[i][next] + tspRecursiveAux(next, nextState, memo, prev, distance, startNode);
    
            if (newCost < minCost) {
                minCost = newCost;
                index = next;
            }
        }
    
        prev[i][state] = index;
        return memo[i][state] = minCost;
    }

    /**
     * Resuelve el problema del viajero (TSP) utilizando un enfoque iterativo
     * con programación dinámica.
     * 
     * @param g           El grafo completo representado como una matriz de
     *                    adyacencia.
     * @param startVertex El vértice de inicio desde el cual se inicia la búsqueda.
     * @return La solución óptima encontrada para el TSP.
     */
    public static Solucion tspIterative(Grafo g, Vertice startVertex) {
        Solucion sol = null;
        double minTourCost = Double.POSITIVE_INFINITY;
        List<Integer> tour = new ArrayList<>();
        int start = g.getVertexIndex(startVertex);
        double[][] distance = g.mapaMatriz();
        int N = distance.length;
        final int END_STATE = (1 << N) - 1;
        Double[][] memo = new Double[N][1 << N];
    
        for (int end = 0; end < N; end++) {
            if (end == start) continue;
            memo[end][(1 << start) | (1 << end)] = distance[start][end];
        }
    
        for (int r = 3; r <= N; r++) {
            for (int subset : combinations(r, N)) {
                if (notIn(start, subset)) continue;
                for (int next = 0; next < N; next++) {
                    if (next == start || notIn(next, subset)) continue;
                    int subsetWithoutNext = subset ^ (1 << next);
                    double minDist = Double.POSITIVE_INFINITY;
                    for (int end = 0; end < N; end++) {
                        if (end == start || end == next || notIn(end, subset)) continue;
                        double newDistance = memo[end][subsetWithoutNext] + distance[end][next];
                        if (newDistance < minDist) {
                            minDist = newDistance;
                        }
                    }
                    memo[next][subset] = minDist;
                }
            }
        }
    
        for (int i = 0; i < N; i++) {
            if (i == start) continue;
            double tourCost = memo[i][END_STATE] + distance[i][start];
            if (tourCost < minTourCost) {
                minTourCost = tourCost;
            }
        }
    
        int lastIndex = start;
        int state = END_STATE;
        tour.add(start);
    
        for (int i = 1; i < N; i++) {
            int index = -1;
            for (int j = 0; j < N; j++) {
                if (j == start || notIn(j, state)) continue;
                if (index == -1) index = j;
                double prevDist = memo[index][state] + distance[index][lastIndex];
                double newDist = memo[j][state] + distance[j][lastIndex];
                if (newDist < prevDist) {
                    index = j;
                }
            }
            tour.add(index);
            state = state ^ (1 << index);
            lastIndex = index;
        }
    
        tour.add(start);
        List<Vertice> vertexes = g.obtenerListaVertices(tour.toArray(new Integer[tour.size()]));
        sol = new Solucion(vertexes, minTourCost);
        return sol;
    }

    /**
     * Verifica si un elemento no está en un subconjunto representado por un entero.
     * 
     * @param elem   El elemento a verificar.
     * @param subset El subconjunto representado como un entero.
     * @return true si el elemento no está en el subconjunto, false en caso
     *         contrario.
     */
    private static boolean notIn(int elem, int subset) {
        return ((1 << elem) & subset) == 0;
    }

    /**
     * Genera todas las combinaciones de tamaño r de un conjunto de n elementos.
     * 
     * @param r El tamaño de las combinaciones a generar.
     * @param n El número total de elementos en el conjunto.
     * @return Una lista de enteros representando las combinaciones generadas.
     */
    private static List<Integer> combinations(int r, int n) {
        List<Integer> subsets = new ArrayList<>();
        combinations(0, 0, r, n, subsets);
        return subsets;
    }

    /**
     * Genera combinaciones de tamaño r a partir de un conjunto de n elementos.
     * 
     * @param set     El conjunto actual representado como un entero.
     * @param at      El índice actual en el conjunto.
     * @param r       El tamaño de las combinaciones a generar.
     * @param n       El número total de elementos en el conjunto.
     * @param subsets La lista donde se almacenan las combinaciones generadas.
     */
    private static void combinations(int set, int at, int r, int n, List<Integer> subsets) {
        int elementsLeftToPick = n - at;
        if (elementsLeftToPick < r)
            return;

        if (r == 0) {
            subsets.add(set);
        } else {
            for (int i = at; i < n; i++) {
                set |= 1 << i;
                combinations(set, i + 1, r - 1, n, subsets);
                set &= ~(1 << i);
            }
        }
    }

    // TSP GREEDY VERTEX
    /**
     * Resuelve el problema del viajero (TSP) utilizando un enfoque voraz basado
     * en la selección del vecino más cercano.
     * 
     * @param g           El grafo completo representado como una lista de
     *                    adyacencia.
     * @param startVertex El vértice de inicio desde el cual se inicia la búsqueda.
     * @return La solución encontrada para el TSP utilizando el algoritmo voraz.
     */
    public static Solucion tspGreedyVertex(Grafo g, Vertice startVertex) {
        if (startVertex == null || !g.contieneVertice(startVertex))
            return null;
    
        HashSet<Vertice> visitados = new HashSet<>();
        LinkedList<Vertice> camino = new LinkedList<>();
        Double totalWeight = 0.0;
    
        Vertice actual = startVertex;
        visitados.add(actual);
        camino.add(actual);
    
        while (visitados.size() < g.size()) {
            Vertice siguiente = vecinoMasCercano(g, visitados, actual);
            camino.add(siguiente);
            totalWeight += g.getPeso(actual, siguiente);
            visitados.add(siguiente);
            actual = siguiente;
        }
        //esto hay que modificarlo, para que funcione todo bien todos los vertices debe teben tener grado 2, dos vecinos siempre
        camino.add(startVertex);
        totalWeight += g.getPeso(actual, startVertex);
    
        return new Solucion(camino, totalWeight);
    }

    /**
     * Busca el vecino más cercano a un vértice actual que no ha sido visitado.
     * 
     * @param g       El grafo en el que se busca el vecino más cercano.
     * @param visited Conjunto de vértices ya visitados.
     * @param actual  El vértice actual desde el cual se busca el vecino más
     *                cercano.
     * @return El vecino más cercano al vértice actual que no ha sido visitado.
     */
    private static Vertice vecinoMasCercano(Grafo g, Set<Vertice> visited, Vertice actual) {
        Double min = Double.MAX_VALUE; 
        Vertice mejorVecino = null; 

        for (Vertice v : g.getVecinos(actual)) {
            if (!visited.contains(v)) {
                Double w = g.getPeso(actual, v);
                if (w < min) {
                    min = w;
                    mejorVecino = v;
                }
            }
        }
        return mejorVecino;
    }

    
    /**
     * Resuelve el problema del viajero (TSP) utilizando un enfoque voraz basado
     * en la selección de aristas.
     * 
     * @param g           El grafo completo representado como una lista de
     *                    adyacencia.
     * @param startVertex El vértice de inicio desde el cual se inicia la búsqueda.
     * @return La solución encontrada para el TSP utilizando el algoritmo voraz.
     */
    public static Solucion tspGreedyEdges(Grafo g, Vertice startVertex) {
        if (startVertex == null || !g.contieneVertice(startVertex))
            return null;

        List<Arista> edges = new ArrayList<>();
        for (Vertice v : g.getVertices()) {
            for (Vertice u : g.getVecinos(v)) {
                if (v.compareTo(u) < 0) {
                    edges.add(new Arista(v, u, g.getPeso(v, u)));
                }
            }
        }
        edges.sort(null);

        Map<Vertice, Integer> degree = new HashMap<>();
        Map<Vertice, Integer> component = new HashMap<>();
        int compId = 0;
        for (Vertice v : g.getVertices()) {
            component.put(v, compId++);
            degree.put(v, 0);
        }

        Map<Vertice, List<Vertice>> selectedEdges = new HashMap<>();
        int selectedEdgesCount = 0;

        for (Arista e : edges) {
            Vertice u = e.getOrigen();
            Vertice v = e.getDestino();

            if (degree.get(u) >= 2 || degree.get(v) >= 2)
                continue;

            boolean isLastEdge = selectedEdgesCount == g.size() - 1;

            if (component.get(u).equals(component.get(v)) && !isLastEdge)
                continue;

            List<Vertice> list = selectedEdges.get(u);
            if (list == null)
                selectedEdges.put(u, list = new ArrayList<>());
            list.add(v);

            list = selectedEdges.get(v);
            if (list == null)
                selectedEdges.put(v, list = new ArrayList<>());
            list.add(u);

            selectedEdgesCount++;
            degree.put(u, degree.get(u) + 1);
            degree.put(v, degree.get(v) + 1);

            int oldComp = component.get(v);
            int newComp = component.get(u);
            for (Vertice w : component.keySet()) {
                if (component.get(w) == oldComp) {
                    component.put(w, newComp);
                }
            }

            if (isLastEdge)
                break;
        }

        if (selectedEdgesCount != g.size())
            throw new RuntimeException("No existe solución válida");

        List<Vertice> path = new ArrayList<>();
        Set<Vertice> visited = new HashSet<>();
        double totalWeight = 0.0;
        Vertice current = startVertex;
        path.add(current);
        visited.add(current);

        while (path.size() < g.size()) {
            for (Vertice neighbor : selectedEdges.get(current)) {
                if (!visited.contains(neighbor)) {
                    path.add(neighbor);
                    totalWeight += g.getPeso(current, neighbor);
                    visited.add(neighbor);
                    current = neighbor;
                    break;
                }
            }
        }

        path.add(startVertex);
        totalWeight += g.getPeso(current, startVertex);

        return new Solucion(path, totalWeight);
    }

}
