package ual.eda2.practica01;

import java.io.FileWriter;
import java.io.IOException;

public class Rendimiento {

    public void ejecutarYRegistrarTiempos(int tipoDistribucion) {
        int[] tamanos = {128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144};
        String[] nombresAlgoritmos = {"fuerzaBrutaSimple", "fuerzaBrutaMejorado", "divideVencerasSimple", "divideVencerasMejorado", "divideVencerasPro", "divideVencerasUltra"};
        int totalPruebas = tamanos.length * nombresAlgoritmos.length;
        int pruebasRealizadas = 0;

        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.append("Algoritmo;Tamaño;Tiempo(ns)\n");

            for (int tamano : tamanos) {
                Generador generador = new Generador();
                Punto[] puntos = generador.generarPuntos(tamano, tipoDistribucion); // Usar distribución uniforme por defecto

                for (String nombreAlgoritmo : nombresAlgoritmos) {
                    long tiempoInicio = System.nanoTime();
                    ejecutarAlgoritmo(nombreAlgoritmo, puntos);
                    long tiempoFin = System.nanoTime();

                    long tiempoTotal = tiempoFin - tiempoInicio;
                    writer.append(nombreAlgoritmo + ";" + tamano + ";" + tiempoTotal + "\n");

                    pruebasRealizadas++;
                    int porcentaje = (int) ((pruebasRealizadas / (double) totalPruebas) * 100);
                    String barraProgreso = "[";
                    int longitudBarra = 70; // Longitud de la barra de progreso
                    int progreso = (int) ((pruebasRealizadas / (double) totalPruebas) * longitudBarra);

                    for (int i = 0; i < longitudBarra; i++) {
                        if (i < progreso) {
                            barraProgreso += "=";
                        } else {
                            barraProgreso += " ";
                        }
                    }
                    barraProgreso += "] " + porcentaje + "%";
                    System.out.print("\r" + barraProgreso);
                }
            }

            System.out.println("\nProceso completado. Resultados guardados en 'resultados.csv'");
            System.out.println("-------------------------------------------------------------------------");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ejecutarAlgoritmo(String nombreAlgoritmo, Punto[] puntos) {
        switch (nombreAlgoritmo) {
            case "fuerzaBrutaSimple":
                Algoritmos.fuerzaBrutaSimple(puntos);
                break;
            case "fuerzaBrutaMejorado":
                Algoritmos.fuerzaBrutaMejorado(puntos);
                break;
            case "divideVencerasSimple":
                Algoritmos.divideVencerasSimple(puntos);
                break;
            case "divideVencerasMejorado":
                Algoritmos.divideVencerasMejorado(puntos);
                break;
            case "divideVencerasPro":
                Algoritmos.divideVencerasPro(puntos);
                break;
            case "divideVencerasUltra":
                Algoritmos.divideVencerasUltra(puntos);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo no reconocido: " + nombreAlgoritmo);
        }
    }

    public void generarReporteDesdeArchivos() {
        String[] nombresArchivos = {
            "datasets/EDALand.txt",
            "datasets/NAclpoint.txt",
            "datasets/NApppoint.txt",
            "datasets/NArdpoint.txt",
            "datasets/NArrpoint.txt",
            "datasets/Spain.txt"
        };
        String[] nombresAlgoritmos = {"fuerzaBrutaSimple", "fuerzaBrutaMejorado", "divideVencerasSimple", "divideVencerasMejorado", "divideVencerasPro", "divideVencerasUltra"};

        try (FileWriter writer = new FileWriter("reporte_archivos.csv")) {
            writer.append("Archivo;Algoritmo;Tiempo(ns)\n");

            for (String archivo : nombresArchivos) {
                Punto[] puntos = Archivos.cargarDatos(archivo);

                for (String nombreAlgoritmo : nombresAlgoritmos) {
                    long tiempoInicio = System.nanoTime();
                    ejecutarAlgoritmo(nombreAlgoritmo, puntos);
                    long tiempoFin = System.nanoTime();

                    long tiempoTotal = tiempoFin - tiempoInicio;
                    writer.append(archivo + ";" + nombreAlgoritmo + ";" + tiempoTotal + "\n");
                }
            }

            System.out.println("Reporte generado en 'reporte_archivos.csv'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
