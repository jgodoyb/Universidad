package ual.eda2.practica01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivos {

    public static String seleccionarArchivoDirectorio(String rutaDirectorio) {
        String[] archivos = listarArchivos(rutaDirectorio);

        System.out.println("\nSeleccione un archivo para cargar:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println((i + 1) + ". " + archivos[i]);
        }
        System.out.println("-----------------------------------");
        System.out.print("Seleccione una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > archivos.length) {
                    throw new IndexOutOfBoundsException(
                            "Opción fuera de rango. Por favor, seleccione una opción válida. Ingrese un número entre 1 y "
                                    + archivos.length + ".");
                }
                opcionValida = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduzca un número.");
                scanner.next(); // Limpiar buffer
            }
        }

        String archivoSeleccionado = archivos[opcion - 1];
        System.out.println("Has escogido analiar los tiempos del archivo: " + archivoSeleccionado);
        System.out.println("---------------------------------------------");

        return rutaDirectorio + "/" + archivoSeleccionado;
    }

    public static Punto[] cargarDatos(String rutaArchivo) {
        ArrayList<Punto> puntos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\t"); // Separador de columnas es tabulador

                if (datos.length == 3) { // Verifica que la línea tenga 3 valores
                    try {
                        double x = Double.parseDouble(datos[1].replace(",", ".")); // Cambia ',' por '.'
                        double y = Double.parseDouble(datos[2].replace(",", "."));
                        puntos.add(new Punto(x, y));
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return puntos.toArray(new Punto[0]);
    }

    public static String[] listarArchivos(String rutaDirectorio) {
        return new java.io.File(rutaDirectorio).list();
    }

}