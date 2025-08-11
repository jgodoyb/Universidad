package ual.eda2.practica02;

import java.util.*;

public class Pruebas {

    private static final int[] VERTEX_SIZES = { 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 60000 };
    private static final double DENSITY_FACTOR = 2.0;
    private static final int NEARBY_NEIGHBORS = 4;
    private static final String[] nombresAlgoritmos = {
            "dijkstra", "dijkstraNaive", "dijkstraPQ", "dijkstraBestFirst",
            "aStar", "dijkstraAStar", "dijkstraBestFirstWPP"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("PRUEBAS DE ALGORITMOS DE CAMINOS MÍNIMOS");
        System.out.println("======================================");
        System.out.println("1. Ejecutar TODOS los algoritmos para TODOS los tamaños de grafo");
        System.out.println("2. Seleccionar algoritmo específico");
        System.out.print("\nSeleccione una opción: ");

        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Se utilizará la opción por defecto (1).");
            opcion = 1;
        }

        if (opcion == 1) {
            ejecutarTodosAlgoritmos();
        } else if (opcion == 2) {
            seleccionarAlgoritmo(scanner);
        } else {
            System.out.println("Opción no válida. Se utilizará la opción por defecto (1).");
            ejecutarTodosAlgoritmos();
        }

        scanner.close();
    }

    private static void seleccionarAlgoritmo(Scanner scanner) {
        System.out.println("\nAlgoritmos disponibles:");
        for (int i = 0; i < nombresAlgoritmos.length; i++) {
            System.out.println((i + 1) + ". " + nombresAlgoritmos[i]);
        }

        System.out.print("\nSeleccione un algoritmo (1-" + nombresAlgoritmos.length + "): ");
        int algoritmoSeleccionado = 0;

        try {
            algoritmoSeleccionado = scanner.nextInt();
            if (algoritmoSeleccionado < 1 || algoritmoSeleccionado > nombresAlgoritmos.length) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Algoritmo no válido. Se ejecutarán todos los algoritmos.");
            ejecutarTodosAlgoritmos();
            return;
        }

        System.out.println("\nTamaños de grafo disponibles:");
        for (int i = 0; i < VERTEX_SIZES.length; i++) {
            System.out.println((i + 1) + ". " + VERTEX_SIZES[i] + " vértices");
        }
        System.out.println((VERTEX_SIZES.length + 1) + ". Todos los tamaños");

        System.out.print("\nSeleccione un tamaño (1-" + (VERTEX_SIZES.length + 1) + "): ");
        int tamañoSeleccionado = 0;

        try {
            tamañoSeleccionado = scanner.nextInt();
            if (tamañoSeleccionado < 1 || tamañoSeleccionado > VERTEX_SIZES.length + 1) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Tamaño no válido. Se ejecutará para todos los tamaños.");
            tamañoSeleccionado = VERTEX_SIZES.length + 1;
        }

        if (tamañoSeleccionado == VERTEX_SIZES.length + 1) {
            // Ejecutar para todos los tamaños
            for (int n : VERTEX_SIZES) {
                ejecutarAlgoritmoEspecifico(algoritmoSeleccionado, n);
            }
        } else {
            // Ejecutar para un tamaño específico
            int n = VERTEX_SIZES[tamañoSeleccionado - 1];
            ejecutarAlgoritmoEspecifico(algoritmoSeleccionado, n);
        }
    }

    private static void ejecutarAlgoritmoEspecifico(int algoritmo, int tamañoGrafo) {
        System.out.println("\n========================================");
        System.out.println("Algoritmo: " + nombresAlgoritmos[algoritmo - 1]);
        System.out.println("Grafo con " + tamañoGrafo + " vértices");
        System.out.println("========================================");
        System.out.printf("%-20s %-20s %-20s\n", "Algoritmo", "Aristas Exploradas", "Tiempo (ms)");
        System.out.println("--------------------------------------------------------------------");

        Network<Vertice> grafo = generarGrafoAleatorio(tamañoGrafo, (int) (tamañoGrafo * DENSITY_FACTOR));
        List<Vertice> vertices = new ArrayList<>(grafo.verticeSet());

        if (vertices.isEmpty()) {
            System.out.println("Error: Grafo vacío para tamaño " + tamañoGrafo);
            return;
        }

        Vertice origen = vertices.get(0);
        Vertice destino = vertices.get(0);
        double maxDistancia = -1;

        for (Vertice v : vertices) {
            if (v == null)
                continue;
            double distancia = origen.heuristicaDistanciaEuclidea(v);
            if (distancia > maxDistancia) {
                maxDistancia = distancia;
                destino = v;
            }
        }

        if (maxDistancia == -1 || destino == null) {
            System.out.println("Error: Destino no válido para tamaño " + tamañoGrafo);
            return;
        }

        Camino camino = null;
        long startTime = System.nanoTime();

        try {
            switch (algoritmo) {
                case 1:
                    camino = Algoritmos.dijkstraV1(grafo, origen, destino);
                    break;
                case 2:
                    camino = Algoritmos.dijkstraNaive(grafo, origen, destino);
                    break;
                case 3:
                    camino = Algoritmos.dijkstraPQ(grafo, origen, destino);
                    break;
                case 4:
                    camino = Algoritmos.dijkstraBestFirst(grafo, origen, destino);
                    break;
                case 5:
                    camino = Algoritmos.aStar(grafo, origen, destino);
                    break;
                case 6:
                    camino = Algoritmos.dijkstraAStar(grafo, origen, destino);
                    break;
                case 7:
                    camino = Algoritmos.dijkstraBestFirstWPP(grafo, origen, destino);
                    break;
            }
        } catch (Exception e) {
            System.out.printf("%-20s %-20s %-20s\n",
                    nombresAlgoritmos[algoritmo - 1], "Error en algoritmo", "-");
            e.printStackTrace();
            return;
        }

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        if (camino != null && camino.getAristasExploradas() >= 0) {
            System.out.printf("%-20s %-20d %-20.3f\n",
                    nombresAlgoritmos[algoritmo - 1], camino.getAristasExploradas(), durationMs);
        } else {
            System.out.printf("%-20s %-20s %-20.3f\n",
                    nombresAlgoritmos[algoritmo - 1], "Error en cálculo", durationMs);
        }
    }

    private static void ejecutarTodosAlgoritmos() {
        System.out.println("\nEjecutando todos los algoritmos secuencialmente...");

        // Para cada tamaño de grafo
        for (int n : VERTEX_SIZES) {
            System.out.println("\n========================================");
            System.out.println("Grafo con " + n + " vértices");
            System.out.println("========================================");
            System.out.printf("%-20s %-20s %-20s\n", "Algoritmo", "Aristas Exploradas", "Tiempo (ms)");
            System.out.println("--------------------------------------------------------------------");

            // Generar el grafo una sola vez para cada tamaño
            Network<Vertice> grafo = generarGrafoAleatorio(n, (int) (n * DENSITY_FACTOR));
            List<Vertice> vertices = new ArrayList<>(grafo.verticeSet());

            // Verificar que el grafo no esté vacío
            if (vertices.isEmpty()) {
                System.out.println("Error: Grafo vacío para tamaño " + n);
                continue;
            }

            Vertice origen = vertices.get(0);
            Vertice destino = vertices.get(0);
            double maxDistancia = -1;

            // Encontrar el vértice más lejano
            for (Vertice v : vertices) {
                if (v == null)
                    continue;
                double distancia = origen.heuristicaDistanciaEuclidea(v);
                if (distancia > maxDistancia) {
                    maxDistancia = distancia;
                    destino = v;
                }
            }

            // Verificar que se seleccionó un destino válido
            if (maxDistancia == -1 || destino == null) {
                System.out.println("Error: Destino no válido para tamaño " + n);
                continue;
            }

            // Ejecutar cada algoritmo con el mismo grafo
            for (int algoritmo = 1; algoritmo <= 7; algoritmo++) {
                Camino camino = null;
                long startTime = System.nanoTime();

                try {
                    switch (algoritmo) {
                        case 1:
                            camino = Algoritmos.dijkstraV1(grafo, origen, destino);
                            break;
                        case 2:
                            camino = Algoritmos.dijkstraNaive(grafo, origen, destino);
                            break;
                        case 3:
                            camino = Algoritmos.dijkstraPQ(grafo, origen, destino);
                            break;
                        case 4:
                            camino = Algoritmos.dijkstraBestFirst(grafo, origen, destino);
                            break;
                        case 5:
                            camino = Algoritmos.aStar(grafo, origen, destino);
                            break;
                        case 6:
                            camino = Algoritmos.dijkstraAStar(grafo, origen, destino);
                            break;
                        case 7:
                            camino = Algoritmos.dijkstraBestFirstWPP(grafo, origen, destino);
                            break;
                    }
                } catch (Exception e) {
                    System.out.printf("%-20s %-20s %-20s\n",
                            nombresAlgoritmos[algoritmo - 1], "Error en algoritmo", "-");
                    e.printStackTrace();
                    continue;
                }

                long endTime = System.nanoTime();
                double durationMs = (endTime - startTime) / 1_000_000.0;

                if (camino != null && camino.getAristasExploradas() >= 0) {
                    System.out.printf("%-20s %-20d %-20.3f\n",
                            nombresAlgoritmos[algoritmo - 1], camino.getAristasExploradas(), durationMs);
                } else {
                    System.out.printf("%-20s %-20s %-20.3f\n",
                            nombresAlgoritmos[algoritmo - 1], "Error en cálculo", durationMs);
                }
            }
        }

        System.out.println("\nComparación de todos los algoritmos completada.");
    }

    private static Network<Vertice> generarGrafoAleatorio(int numVertices, int numAristas) {
        // ...resto del método sin cambios...
        Network<Vertice> grafo = new Network<>();
        Random rand = new Random(42);
        Map<Integer, Vertice> idToVertice = new HashMap<>();
        List<Vertice> vertices = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            String id = "v" + i;
            double x = rand.nextDouble() * 10000;
            double y = rand.nextDouble() * 10000;
            Vertice v = new Vertice(id, x, y);
            grafo.addVertice(v);
            idToVertice.put(i, v);
            vertices.add(v);
        }

        for (Vertice v : vertices) {
            List<Map.Entry<Vertice, Double>> distancias = new ArrayList<>();
            for (Vertice u : vertices) {
                if (u != v) {
                    double dist = v.heuristicaDistanciaEuclidea(u);
                    distancias.add(new AbstractMap.SimpleEntry<>(u, dist));
                }
            }
            distancias.sort(Comparator.comparingDouble(Map.Entry::getValue));
            for (int i = 0; i < Math.min(NEARBY_NEIGHBORS, distancias.size()); i++) {
                Vertice vecino = distancias.get(i).getKey();
                if (!grafo.containsEdge(v, vecino)) {
                    double distEuclidea = distancias.get(i).getValue();
                    double peso = distEuclidea * (0.8 + rand.nextDouble() * 0.4);
                    grafo.addEdge(v, vecino, peso);
                }
            }
        }

        Set<String> aristasExistentes = new HashSet<>();
        for (Vertice v : vertices) {
            for (Vertice u : grafo.getNeighbors(v)) {
                String edgeId = Math.min(v.hashCode(), u.hashCode()) + "-" + Math.max(v.hashCode(), u.hashCode());
                aristasExistentes.add(edgeId);
            }
        }

        int aristasActuales = aristasExistentes.size();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices, rand);

        while (aristasActuales < numAristas && !indices.isEmpty()) {
            int v1 = indices.get(rand.nextInt(indices.size()));
            int v2 = indices.get(rand.nextInt(indices.size()));
            if (v1 == v2)
                continue;
            Vertice vert1 = idToVertice.get(v1);
            Vertice vert2 = idToVertice.get(v2);
            String edgeId = Math.min(v1, v2) + "-" + Math.max(v1, v2);
            if (!aristasExistentes.contains(edgeId)) {
                double distEuclidea = vert1.heuristicaDistanciaEuclidea(vert2);
                double peso = distEuclidea * (0.8 + rand.nextDouble() * 0.4);
                grafo.addEdge(vert1, vert2, peso);
                aristasExistentes.add(edgeId);
                aristasActuales++;
            }
        }

        if (aristasActuales < numVertices - 1) {
            List<Integer> conectados = new ArrayList<>();
            conectados.add(0);
            for (int i = 1; i < numVertices && aristasActuales < numAristas; i++) {
                int v1 = i;
                int v2 = conectados.get(rand.nextInt(conectados.size()));
                String edgeId = Math.min(v1, v2) + "-" + Math.max(v1, v2);
                if (!aristasExistentes.contains(edgeId)) {
                    Vertice vert1 = idToVertice.get(v1);
                    Vertice vert2 = idToVertice.get(v2);
                    double distEuclidea = vert1.heuristicaDistanciaEuclidea(vert2);
                    double peso = distEuclidea * (0.8 + rand.nextDouble() * 0.4);
                    grafo.addEdge(vert1, vert2, peso);
                    aristasExistentes.add(edgeId);
                    aristasActuales++;
                }
                conectados.add(v1);
            }
        }

        return grafo;
    }
}