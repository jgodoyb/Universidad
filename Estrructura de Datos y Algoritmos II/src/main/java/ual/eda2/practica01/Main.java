package ual.eda2.practica01;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                boolean salir = false;

                while (!salir) {
                        System.out.println(
                                        "\n-------------------------------------------------------------------------");
                        System.out.println("Seleccione una opción:");
                        System.out.println("1 - Cargar puntos desde un archivo en /datasets");
                        System.out.println("2 - Generar puntos aleatorios con una distribución específica");
                        System.out.println("3 - Generar reporte de rendimiento en resultados.csv");
                        System.out.println("4 - Salir");
                        System.out.print("Opción: ");

                        // Leer la opción como texto
                        int opcion = scanner.nextInt();

                        Punto[] puntos = null;

                        switch (opcion) {
                                case 1:
                                        // Carga de datos y medición de tiempos desde archivo
                                        puntos = Archivos.cargarDatos(Archivos.seleccionarArchivoDirectorio(
                                                        "src/main/java/ual/eda2/practica01/datasets"));

                                        Utilidades.imprimirTiempos(puntos);
                                        break;

                                case 2:
                                        // Generar puntos aleatorios en distribución gaussiana, uniforme o exponencial
                                        Generador generador = new Generador();
                                        puntos = generador.ejecutar();

                                        Utilidades.imprimirTiempos(puntos);
                                        break;

                                case 3:
                                        // Generación de array de puntos de testeo y reporte de rendimiento
                                        System.out.println(
                                                        "Selecciona el tipo de distribución de puntos a generar para el reporte con tamaños 2^n (128-262144):");
                                        System.out.println("1 - Gaussiana");
                                        System.out.println("2 - Uniforme");
                                        System.out.println("3 - Exponencial");
                                        System.out.print("Opción: ");
                                        scanner.nextLine();
                                        String distInput = scanner.nextLine();
                                        int tipoDistribucion;
                                        try {
                                                tipoDistribucion = Integer.parseInt(distInput);
                                        } catch (NumberFormatException e) {
                                                System.out.println("Error: Debes introducir un número válido.");
                                                continue; // vuelve al menú principal
                                        }

                                        Rendimiento rendimiento = new Rendimiento();
                                        rendimiento.ejecutarYRegistrarTiempos(tipoDistribucion);
                                        break;

                                case 4:
                                        salir = true;
                                        System.out.println("Saliendo del programa...");
                                        break;

                                default:
                                        System.out.println(
                                                        "Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                        }
                }

                // Cerramos el Scanner justo al final de todo
                scanner.close();
        }
}
