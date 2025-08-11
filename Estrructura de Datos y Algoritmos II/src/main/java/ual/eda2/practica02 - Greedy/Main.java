package ual.eda2.practica02;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Network para cargar el grafo
        Network<Vertice> net = new Network<>();

        // Mostrar al usuario los archivos disponibles y permitirle seleccionar uno
        System.out.println("\nSeleccione el archivo para la carga de datos:");
        File[] archivos = Utilidades.mostrarArchivos();
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay archivos disponibles para cargar.");
            return;
        }
        System.out.println("--------------------------------");
        int archivoSeleccionado = Utilidades.leerEntero("Seleccione el archivo que desee: ", 1, archivos.length);
        String archivo = archivos[archivoSeleccionado - 1].getName();

        // Cargar el archivo seleccionado
        Utilidades.cargarArchivo(archivo, net);

        // Obtener los vértices disponibles para elegir el origen y destino
        List<Vertice> vertices = new ArrayList<>(net.verticeSet());
        System.out.println("\nSeleccione el origen:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println((i + 1) + ". " + vertices.get(i).getIdentificador());
        }
        int origenSeleccionado = Utilidades.leerEntero("Seleccione el origen: ", 1, vertices.size());
        Vertice start = vertices.get(origenSeleccionado - 1);

        System.out.println("\nSeleccione el destino:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println((i + 1) + ". " + vertices.get(i).getIdentificador());
        }
        int destinoSeleccionado = Utilidades.leerEntero("Seleccione el destino: ", 1, vertices.size());
        Vertice end = vertices.get(destinoSeleccionado - 1);

        // Mostrar los algoritmos disponibles
        System.out.println("\nAlgoritmos disponibles");
        System.out.println("-------------------------------------");
        System.out.println("1. Dijkstra Basico");
        System.out.println("2. Dijkstra Naive");
        System.out.println("3. Dijkstra con Cola de Prioridad");
        System.out.println("4. Dijkstra Best First");
        System.out.println("5. A*");
        System.out.println("6. Dijkstra A*");
        System.out.println("7. Dijkstra Best First WPP");
        System.out.println("-------------------------------------");

        int algoritmoSeleccionado = Utilidades.leerEntero("Seleccione el algoritmo a ejecutar: ", 1, 7);

        // Ejecutar el algoritmo seleccionado
        Camino camino = null;
        switch (algoritmoSeleccionado) {
            case 1:
                camino = Algoritmos.dijkstraV1(net, start, end);
                break;
            case 2:
                camino = Algoritmos.dijkstraNaive(net, start, end);
                break;
            case 3:
                camino = Algoritmos.dijkstraPQ(net, start, end);
                break;
            case 4:
                camino = Algoritmos.dijkstraBestFirst(net, start, end);
                break;
            case 5:
                camino = Algoritmos.aStar(net, start, end);
                break;
            case 6:
                camino = Algoritmos.dijkstraAStar(net, start, end);
                break;
            case 7:
                camino = Algoritmos.dijkstraBestFirstWPP(net, start, end);
                break;
            default:
                System.out.println("Algoritmo no válido");
                return;
        }

        // Mostrar el resultado de la solución
        System.out.println(camino.toString());
    }
}
