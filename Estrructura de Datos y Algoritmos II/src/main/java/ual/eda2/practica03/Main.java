package ual.eda2.practica03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    private static final String DATASETS_PATH = "equipo-equipo-a\\src\\main\\java\\ual\\eda2\\practica03\\datasets";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Cargar grafo desde archivo");
            System.out.println("2. Generar grafo aleatorio");
            System.out.println("3. Ejecutar experimento comparativo y generar CSV");
            System.out.println("4. Experimento con grafos aleatorios (variando nodos y densidad)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    cargarDesdeArchivo(scanner);
                    break;
                case 2:
                    generarGrafoAleatorio(scanner);
                    break;
                case 3:
                    generarCSVExperimental();
                    break;
                case 4:
                    generarCSVExperimentalAleatorio();
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void cargarDesdeArchivo(Scanner scanner) {
        // Listar archivos disponibles en datasets
        File carpeta = new File(DATASETS_PATH);
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".txt"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos en " + DATASETS_PATH);
            return;
        }

        System.out.println("\n=== ARCHIVOS DISPONIBLES ===");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println((i + 1) + ". " + archivos[i].getName());
        }

        System.out.print("Seleccione un archivo (1-" + archivos.length + "): ");
        int seleccion;
        try {
            seleccion = Integer.parseInt(scanner.nextLine());
            if (seleccion < 1 || seleccion > archivos.length) {
                System.out.println("Selección no válida.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número.");
            return;
        }

        String rutaArchivo = archivos[seleccion - 1].getAbsolutePath();
        ejecutarConGrafo(cargarGrafo(rutaArchivo));
    }

    private static void generarGrafoAleatorio(Scanner scanner) {
        System.out.println("\n=== GENERAR GRAFO ALEATORIO ===");

        System.out.print("Ingrese el número de vértices: ");
        int numVertices;
        try {
            numVertices = Integer.parseInt(scanner.nextLine());
            if (numVertices < 3) {
                System.out.println("El grafo debe tener al menos 3 vértices. Se usarán 3.");
                numVertices = 3;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número. Se usarán 5 vértices.");
            numVertices = 5;
        }

        System.out.print("Ingrese la densidad (0-100): ");
        double densidad;
        try {
            densidad = Double.parseDouble(scanner.nextLine());
            if (densidad < 0 || densidad > 100) {
                System.out.println("La densidad debe estar entre 0 y 100. Se usará 50.");
                densidad = 50;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número. Se usará densidad 50.");
            densidad = 50;
        }

        Grafo g = new Grafo();
        generarGrafo(g, numVertices, densidad);

        System.out.println("Grafo generado con " + numVertices + " vértices y densidad " + densidad);
        ejecutarConGrafo(g);
    }

    private static Grafo cargarGrafo(String ruta) {
        Grafo g = new Grafo();
        cargarDatos(g, ruta);
        return g;
    }

    private static void ejecutarConGrafo(Grafo g) {
        // Buscar un vértice válido
        Vertice v1 = null;
        for (Vertice v : g.getVertices()) {
            // Usamos el primer vértice que encontremos
            v1 = v;
            break;
        }

        if (v1 == null) {
            System.out.println("Error: No se encontraron vértices en el grafo.");
            return;
        }

        System.out.println("Usando vértice de origen: " + v1.getNombre());

        // Ejecutamos todos los algoritmos con el grafo cargado
        try {
            //System.out.println("Simple Paths:");
            //System.out.println(Algoritmos.simplePaths(g, v1));

            System.out.println("\nTSP Simple Paths:");
            long startTime = System.currentTimeMillis();
            System.out.println(Algoritmos.tspSimplePaths(g, v1));
            long endTime = System.currentTimeMillis();
            long durationSP = endTime - startTime; // Duración en milisegundos
            System.out.println("Duración de Simple Paths: " + durationSP + " ms");

            System.out.println("\nTSP mejor fuerza bruta:");
            long startTime2 = System.currentTimeMillis();
            System.out.println(Algoritmos.tspBruteForce(g, v1));
            long endTime2 = System.currentTimeMillis();
            long durationBF = endTime2 - startTime2; // Duración en milisegundos
            System.out.println("Duración de Fuerza Bruta: " + durationBF + " ms");

            System.out.println("\nTSP Iterativo con Programación Dinámica:");
            long startTime3 = System.currentTimeMillis();
            System.out.println(Algoritmos.tspIterative(g, v1));
            long endTime3 = System.currentTimeMillis();
            long durationIterative = endTime3 - startTime3; // Duración en milisegundos
            System.out.println("Duración de Iterativo: " + durationIterative + " ms");

            System.out.println("\nTSP Recursivo:");
            long startTime4 = System.currentTimeMillis();
            System.out.println(Algoritmos.tspRecursive(g, v1));
            long endTime4 = System.currentTimeMillis();
            long durationRecursive = endTime4 - startTime4; // Duración en milisegundos
            System.out.println("Duración de Recursivo: " + durationRecursive + " ms");

            System.out.println("\nTSP Greedy por Vértices (vecino más cercano):");
            long startTime5 = System.currentTimeMillis();
            System.out.println(Algoritmos.tspGreedyVertex(g, v1));
            long endTime5 = System.currentTimeMillis();
            long durationGreedyVertex = endTime5 - startTime5; // Duración en milisegundos
            System.out.println("Duración de Greedy por Vértices: " + durationGreedyVertex + " ms");

            System.out.println("\nTSP Greedy por Aristas:");
            long startTime6 = System.currentTimeMillis();
            System.out.println(Algoritmos.tspGreedyEdges(g, v1));
            long endTime6 = System.currentTimeMillis();
            long durationGreedyEdges = endTime6 - startTime6; // Duración en milisegundos
            System.out.println("Duración de Greedy por Aristas: " + durationGreedyEdges + " ms");

            // Comparar tiempos de ejecución
            System.out.println("\n=== COMPARATIVA DE TIEMPOS ===");
            System.out.println("Simple Paths: " + durationSP + " ms");
            System.out.println("Fuerza Bruta: " + durationBF + " ms");
            System.out.println("Iterativo: " + durationIterative + " ms");
            System.out.println("Recursivo: " + durationRecursive + " ms");
            System.out.println("Greedy por Vértices: " + durationGreedyVertex + " ms");
            System.out.println("Greedy por Aristas: " + durationGreedyEdges + " ms");
            
        } catch (Exception e) {
            System.out.println("Error al ejecutar los algoritmos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    private static void generarGrafo(Grafo g, int n, double densidad) {
        g.setDirigido(false);
        int ndigitos = ("" + (n - 1)).length();
        List<String> lista = new ArrayList<>();
        HashSet<Arista> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            lista.add(String.format("%0" + ndigitos + "d", i));
        }
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                hs.add(new Arista(new Vertice(lista.get(i)), new Vertice(lista.get(j)), Math.random() * 100));
            }
        }

        Collections.shuffle(lista);
        for (int i = 0; i < lista.size() - 1; i++) {
            String origen = lista.get(i);
            String destino = lista.get(i + 1);
            g.addArista(origen, destino, Math.random() * 100);
            if (origen.compareTo(destino) > 0) {
                hs.remove(new Arista(new Vertice(destino), new Vertice(origen), 0));
            } else {
                hs.remove(new Arista(new Vertice(origen), new Vertice(destino), 0));
            }

        }
        g.addArista(lista.getLast(), lista.getFirst(), Math.random() * 100);
        if (lista.getLast().compareTo(lista.getFirst()) > 0) {
            hs.remove(new Arista(new Vertice(lista.getFirst()), new Vertice(lista.getLast()), 0));
        } else {
            hs.remove(new Arista(new Vertice(lista.getLast()), new Vertice(lista.getFirst()), 0)); 
        }

        int min = n;
        int max = n * (n - 1) / 2;
        int aristaAgregar = (int) ((max - min) * densidad / 100);
        List<Arista> aux = new ArrayList<>(hs);
        Collections.shuffle(aux);
        for (int i = 0; i < aristaAgregar; i++) {
            Arista a = aux.get(i);
            g.addArista(a.getOrigen(), a.getDestino(), a.getPeso());
        }

        g.setOrigen(new Vertice(lista.get(0)));

    }

    private static void cargarDatos(Grafo g, String ruta) {
        File f = new File(ruta);
        try {
            Scanner sc = new Scanner(f);
            g.setDirigido(!sc.nextLine().equals("0"));
            int n = Integer.parseInt(sc.nextLine());

            // Guardamos el primer vértice leído para usarlo como origen
            Vertice primerVertice = null;

            for (int i = 0; i < n; i++) {
                String nombre = sc.nextLine();
                Vertice v = new Vertice(nombre);
                g.addVertice(v);

                // Guardamos el primer vértice
                if (i == 0) {
                    primerVertice = v;
                    g.setOrigen(v);
                }
            }

            int m = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < m; i++) {
                String[] aux = sc.nextLine().split(" ");
                g.addArista(aux[0], aux[1], Double.valueOf(aux[2]));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void generarCSVExperimental() {
        System.out.println("\n=== EJECUTANDO EXPERIMENTO COMPARATIVO ===");
        System.out.println("Esto puede tardar varios minutos. Por favor, espere...");
        
        // Lista de archivos a procesar
        String[] archivos = {
            "graphTSP01.txt", "graphTSP02.txt", "graphTSP03.txt", "graphTSP04.txt", 
            "graphTSP05.txt", "graphTSP06.txt", "graphTSP07.txt", "graphTSP08.txt",
            "graphTSP09.txt", "graphTSP10.txt", "graphTSP11.txt"
        };
        
        // Nombre del archivo CSV de salida con timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String csvFile = "resultados_tsp_" + timestamp + ".csv";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Escribir encabezado del CSV actualizado para mostrar ms en lugar de s
            writer.println("Archivo,Nodos,Brute Force (ms),Recursivo (ms),Iterativo (ms),Greedy Vert. (ms),Greedy Edge (ms),Dist. Óptima,Dist. Greedy V,Dist. Greedy E");
            
            // Procesar cada archivo
            for (String archivo : archivos) {
                try {
                    // Intentar procesar este archivo
                    String rutaCompleta = DATASETS_PATH + "\\" + archivo;
                    System.out.println("\nProcesando " + archivo + "...");
                    
                    // Cargar el grafo
                    Grafo g = cargarGrafo(rutaCompleta);
                    int numNodos = g.size();
                    System.out.println("Grafo cargado: " + numNodos + " nodos");
                    
                    if (numNodos == 0) {
                        System.out.println("Error: El grafo está vacío. Omitiendo archivo.");
                        continue;
                    }
                    
                    // Obtener vértice de origen
                    Vertice origen = null;
                    for (Vertice v : g.getVertices()) {
                        origen = v;
                        break;
                    }
                    
                    if (origen == null) {
                        System.out.println("Error: No se pudo obtener un vértice de origen. Omitiendo archivo.");
                        continue;
                    }
                    
                    // Variables para almacenar resultados EN MILISEGUNDOS (sin dividir por 1000)
                    long tiempoBruteForce = 0, tiempoRecursivo = 0, tiempoIterativo = 0;
                    long tiempoGreedyV = 0, tiempoGreedyE = 0;
                    double distOptima = 0, distGreedyV = 0, distGreedyE = 0;
                    
                    // Formatear números sin decimales para los milisegundos
                    DecimalFormat dfTiempo = new DecimalFormat("0");
                    // Mantener 3 decimales para las distancias
                    DecimalFormat dfDistancia = new DecimalFormat("0.000");
                    
                    // Ejecutar Brute Force (solo para grafos pequeños)
                    Solucion solBruteForce = null;
                    if (numNodos <= 12) {
                        System.out.println("  Ejecutando Brute Force...");
                        long inicio = System.currentTimeMillis();
                        solBruteForce = Algoritmos.tspBruteForce(g, origen);
                        long fin = System.currentTimeMillis();
                        tiempoBruteForce = fin - inicio; // Tiempo en milisegundos
                        
                        if (solBruteForce != null) {
                            distOptima = solBruteForce.getDistancia();
                        }
                    }
                    
                    // Ejecutar Recursivo con Memorización
                    System.out.println("  Ejecutando Recursivo...");
                    long inicio = System.currentTimeMillis();
                    Solucion solRecursivo = Algoritmos.tspRecursive(g, origen);
                    long fin = System.currentTimeMillis();
                    tiempoRecursivo = fin - inicio; // Tiempo en milisegundos
                    
                    if (solBruteForce == null && solRecursivo != null) {
                        distOptima = solRecursivo.getDistancia();
                    }
                    
                    // Ejecutar Iterativo con PD
                    System.out.println("  Ejecutando Iterativo...");
                    inicio = System.currentTimeMillis();
                    Solucion solIterativo = Algoritmos.tspIterative(g, origen);
                    fin = System.currentTimeMillis();
                    tiempoIterativo = fin - inicio; // Tiempo en milisegundos
                    
                    if (solBruteForce == null && solRecursivo == null && solIterativo != null) {
                        distOptima = solIterativo.getDistancia();
                    }
                    
                    // Ejecutar Greedy por Vértices
                    System.out.println("  Ejecutando Greedy por Vértices...");
                    inicio = System.currentTimeMillis();
                    Solucion solGreedyV = Algoritmos.tspGreedyVertex(g, origen);
                    fin = System.currentTimeMillis();
                    tiempoGreedyV = fin - inicio; // Tiempo en milisegundos
                    
                    if (solGreedyV != null) {
                        distGreedyV = solGreedyV.getDistancia();
                    }
                    
                    // Ejecutar Greedy por Aristas
                    System.out.println("  Ejecutando Greedy por Aristas...");
                    inicio = System.currentTimeMillis();
                    Solucion solGreedyE = Algoritmos.tspGreedyEdges(g, origen);
                    fin = System.currentTimeMillis();
                    tiempoGreedyE = fin - inicio; // Tiempo en milisegundos
                    
                    if (solGreedyE != null) {
                        distGreedyE = solGreedyE.getDistancia();
                    }
                    
                    // Escribir resultados en CSV
                    StringBuilder sb = new StringBuilder();
                    sb.append(archivo).append(",");
                    sb.append(numNodos).append(",");
                    
                    // Tiempos en milisegundos sin decimales
                    sb.append(numNodos <= 12 ? dfTiempo.format(tiempoBruteForce) : "N/A").append(",");
                    sb.append(dfTiempo.format(tiempoRecursivo)).append(",");
                    sb.append(dfTiempo.format(tiempoIterativo)).append(",");
                    sb.append(dfTiempo.format(tiempoGreedyV)).append(",");
                    sb.append(dfTiempo.format(tiempoGreedyE)).append(",");
                    
                    // Distancias con 3 decimales
                    sb.append(dfDistancia.format(distOptima)).append(",");
                    sb.append(dfDistancia.format(distGreedyV)).append(",");
                    sb.append(dfDistancia.format(distGreedyE));
                    
                    writer.println(sb.toString());
                    System.out.println("  Resultados guardados para " + archivo);
                    
                } catch (Exception e) {
                    System.out.println("Error procesando " + archivo + ": " + e.getMessage());
                    e.printStackTrace();
                }
            }
            
            System.out.println("\n¡Experimento completado!");
            System.out.println("Resultados guardados en " + csvFile);
            
        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void generarCSVExperimentalAleatorio() {
        System.out.println("\n=== EJECUTANDO EXPERIMENTO CON GRAFOS ALEATORIOS ===");
        System.out.println("Esto puede tardar varios minutos. Por favor, espere...");
        
        // Definir los parámetros del experimento
        int[] tamanos = {8, 12, 16, 20};
        int[] densidades = {25, 50, 75, 100};
        
        // Nombre del archivo CSV de salida con timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String csvFile = "resultados_aleatorios_" + timestamp + ".csv";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Escribir encabezado del CSV
            writer.println("Nodos,Densidad (%),Greedy Vert. (ms),Greedy Vert. Dist.,Greedy Edge (ms),Greedy Edge Dist.,Iterativo (ms),Iterativo Dist.");
            
            // Para cada combinación de tamaño y densidad
            for (int nodos : tamanos) {
                for (int densidad : densidades) {
                    System.out.println("\nGenerando grafo con " + nodos + " nodos y densidad " + densidad + "%...");
                    
                    // Variables para almacenar promedios
                    long tiempoGreedyV = 0, tiempoGreedyE = 0, tiempoIterativo = 0;
                    double distGreedyV = 0, distGreedyE = 0, distIterativo = 0;
                    int iteraciones = 3; // Número de repeticiones
                    
                    // Flags para indicar si un algoritmo se ejecutó correctamente
                    boolean greedyVOK = true, greedyEOK = true, iterativoOK = true;
                    
                    // Ejecutar varias iteraciones y promediar
                    for (int iter = 0; iter < iteraciones; iter++) {
                        // Crear grafo aleatorio
                        Grafo g = new Grafo();
                        try {
                            generarGrafo(g, nodos, densidad);
                        } catch (Exception e) {
                            System.out.println("  Error generando grafo: " + e.getMessage());
                            greedyVOK = greedyEOK = iterativoOK = false;
                            break;
                        }
                        
                        // Obtener vértice de origen
                        Vertice origen = null;
                        try {
                            for (Vertice v : g.getVertices()) {
                                origen = v;
                                break;
                            }
                            
                            if (origen == null) {
                                System.out.println("  Error: No se pudo obtener un vértice de origen.");
                                greedyVOK = greedyEOK = iterativoOK = false;
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("  Error obteniendo origen: " + e.getMessage());
                            greedyVOK = greedyEOK = iterativoOK = false;
                            break;
                        }
                        
                        // Greedy por Vértices
                        try {
                            long inicio = System.currentTimeMillis();
                            Solucion solGreedyV = Algoritmos.tspGreedyVertex(g, origen);
                            long fin = System.currentTimeMillis();
                            tiempoGreedyV += (fin - inicio);
                            
                            if (solGreedyV != null) {
                                distGreedyV += solGreedyV.getDistancia();
                            } else {
                                greedyVOK = false;
                            }
                        } catch (Exception e) {
                            System.out.println("  Error en Greedy por Vértices: " + e.getMessage());
                            greedyVOK = false;
                        }
                        
                        // Greedy por Aristas
                        try {
                            long inicio = System.currentTimeMillis();
                            Solucion solGreedyE = Algoritmos.tspGreedyEdges(g, origen);
                            long fin = System.currentTimeMillis();
                            tiempoGreedyE += (fin - inicio);
                            
                            if (solGreedyE != null) {
                                distGreedyE += solGreedyE.getDistancia();
                            } else {
                                greedyEOK = false;
                            }
                        } catch (Exception e) {
                            System.out.println("  Error en Greedy por Aristas: " + e.getMessage());
                            greedyEOK = false;
                        }
                        
                        // Iterativo con PD (solo para grafos pequeños-medianos)
                        if (nodos <= 20) {
                            try {
                                long inicio = System.currentTimeMillis();
                                Solucion solIterativo = Algoritmos.tspIterative(g, origen);
                                long fin = System.currentTimeMillis();
                                tiempoIterativo += (fin - inicio);
                                
                                if (solIterativo != null) {
                                    distIterativo += solIterativo.getDistancia();
                                } else {
                                    iterativoOK = false;
                                }
                            } catch (Exception e) {
                                System.out.println("  Error en Iterativo: " + e.getMessage());
                                iterativoOK = false;
                            }
                        } else {
                            iterativoOK = false; // No se ejecuta para grafos grandes
                        }
                        
                        System.out.println("  Iteración " + (iter + 1) + " completada");
                    }
                    
                    // Calcular promedios solo si se ejecutaron correctamente
                    if (greedyVOK) {
                        tiempoGreedyV /= iteraciones;
                        distGreedyV /= iteraciones;
                    }
                    
                    if (greedyEOK) {
                        tiempoGreedyE /= iteraciones;
                        distGreedyE /= iteraciones;
                    }
                    
                    if (iterativoOK) {
                        tiempoIterativo /= iteraciones;
                        distIterativo /= iteraciones;
                    }
                    
                    // Formatear números
                    DecimalFormat dfTiempo = new DecimalFormat("0");
                    DecimalFormat dfDistancia = new DecimalFormat("0.000");
                    
                    // Escribir resultados en CSV
                    StringBuilder sb = new StringBuilder();
                    sb.append(nodos).append(",");
                    sb.append(densidad).append(",");
                    
                    // Usar N/A para algoritmos que fallaron
                    sb.append(greedyVOK ? dfTiempo.format(tiempoGreedyV) : "N/A").append(",");
                    sb.append(greedyVOK ? dfDistancia.format(distGreedyV) : "N/A").append(",");
                    sb.append(greedyEOK ? dfTiempo.format(tiempoGreedyE) : "N/A").append(",");
                    sb.append(greedyEOK ? dfDistancia.format(distGreedyE) : "N/A").append(",");
                    sb.append(iterativoOK ? dfTiempo.format(tiempoIterativo) : "N/A").append(",");
                    sb.append(iterativoOK ? dfDistancia.format(distIterativo) : "N/A");
                    
                    writer.println(sb.toString());
                    System.out.println("  Resultados guardados para " + nodos + " nodos, " + densidad + "% densidad");
                }
            }
            
            System.out.println("\n¡Experimento con grafos aleatorios completado!");
            System.out.println("Resultados guardados en " + csvFile);
            
        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
