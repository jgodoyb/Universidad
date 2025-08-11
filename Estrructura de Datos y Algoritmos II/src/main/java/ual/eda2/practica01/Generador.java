package ual.eda2.practica01;

import java.util.Random;
import java.util.Scanner;


public class Generador {

    public Punto[] ejecutar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de distribución:");
        System.out.println("1 - Gaussiana");
        System.out.println("2 - Uniforme");
        System.out.println("3 - Exponencial");
        
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        System.out.print("Cantidad de puntos a generar: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= 0) {
            System.out.println("Error: La cantidad de puntos debe ser mayor que 0.");
            return null;
        }

        return generarPuntos(cantidad, opcion);
    }

    public Punto[] generarPuntos(int cantidad, int tipoDistribucion) {
        Random random = new Random();

        Punto[] puntos = new Punto[cantidad];

        for (int i = 0; i < cantidad; i++) {
            switch (tipoDistribucion) {
                case 1: // Distribución Gaussiana
                    puntos[i] = new Punto(random.nextGaussian() * 100, random.nextGaussian() * 100);
                    break;

                case 2: // Distribución Uniforme
                    puntos[i] = new Punto(random.nextDouble() * 100, random.nextDouble() * 100);
                    break;

                case 3: // Distribución Exponencial
                    puntos[i] = new Punto(-Math.log(1 - random.nextDouble()) * 10, 
                                          -Math.log(1 - random.nextDouble()) * 10);
                    break;

                default:
                    System.out.println("Opción no válida, se usará Gaussiana por defecto.");
                    puntos[i] = new Punto(random.nextGaussian() * 25, random.nextGaussian() * 25);
            }
        }
        
        return puntos;
    }

}
