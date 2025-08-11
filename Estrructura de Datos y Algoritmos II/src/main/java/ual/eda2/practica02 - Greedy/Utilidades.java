package ual.eda2.practica02;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {
    private static String dir = "equipo-equipo-a\\src\\main\\java\\ual\\eda2\\practica02\\datasets\\";

    public static String format(double d) {
        return String.format("%.3f", d);
    }

    public static String format(double d, int nDecimales) {
        return String.format("%." + nDecimales + "f", d);
    }

    public static String format(int n, int nDigitos) {
        return String.format("%0" + nDigitos + "d", n);
    }

    public static int leerEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            try {
                opcion = Integer.parseInt(sc.nextLine());
                valido = true; // Si se convierte correctamente, establecemos valido como true
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un valor numérico.");
            }
        } while (!valido);
        sc.close();
        return opcion;
    }

    public static int leerEntero(String mensaje, int max) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            try {
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 0 && opcion <= max) {
                    valido = true; // El valor está dentro del rango [0, max]
                } else {
                    System.out.println("Error: El valor debe estar entre 0 y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un valor numérico.");
            }
        } while (!valido);
        sc.close();
        return opcion;
    }

    public static int leerEntero(String mensaje, int min, int max) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            try {
                int opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= min || opcion <= max) {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir valor numerico");
            }
            System.out.println("Error: Debe introducir una opcion entre " + min + " y " + max);
            sc.close();
        } while (true);
    }

    public static double leerDecimal(String mensaje) {
        Scanner sc = new Scanner(System.in);
        double opcion = 0.0;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            try {
                opcion = Double.parseDouble(sc.nextLine()); // Intentamos convertir la entrada a decimal
                valido = true; // Si la conversión es correcta, se marca como válido
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un valor numérico decimal.");
            }
        } while (!valido);
        sc.close();
        return opcion;
    }

    public static double leerDecimal(String mensaje, double max) {
        Scanner sc = new Scanner(System.in);
        double opcion = -1.0;
        boolean valido = false;

        do {
            System.out.println(mensaje);
            try {
                opcion = Double.parseDouble(sc.nextLine()); // Intentamos convertir la entrada a decimal
                if (opcion >= 0 && opcion <= max) {
                    valido = true; // El valor está dentro del rango [0, max]
                } else {
                    System.out.println("Error: El valor debe estar entre 0 y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un valor numérico decimal.");
            }
        } while (!valido);
        sc.close();
        return opcion;
    }

    public static double leerDecimal(String mensaje, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double opcion = 0.0;
        boolean valido = false;

        do {
            System.out.println(mensaje);
            try {
                opcion = Double.parseDouble(sc.nextLine()); // Intentamos convertir la entrada a decimal
                if (opcion >= min && opcion <= max) {
                    valido = true; // El valor está dentro del rango [min, max]
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un valor numérico decimal.");
            }
        } while (!valido);
        sc.close();
        return opcion;
    }

    public static File[] mostrarArchivos() {
        File f = new File(dir);
        File[] lista = f.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".txt");
            }
        });
        Arrays.sort(lista, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        for (int i = 0; i < lista.length; i++) {
            System.out.println((i + 1) + ". " + lista[i].getName());
        }
        return lista;
    }

    public static void cargarArchivo(String archivo, Network<Vertice> net) {
        File f = new File(dir + archivo);
        if (!f.exists()) {
            System.out.println("El archivo " + f.getAbsolutePath() + " no existe");
            return;
        }
        try {
            Scanner sc = new Scanner(f);
            int nVertice = -1;
            int nEdges = -1;
            String[] tokens;
            if (sc.hasNext()) {
                net.setDirected(sc.nextLine().equals("1"));
            }
            if (sc.hasNext()) {
                nVertice = Integer.parseInt(sc.nextLine().trim());
            }
            for (int i = 0; i < nVertice; i++) {
                tokens = sc.nextLine().trim().split(" ");
                Vertice v = null;
                if (tokens.length == 3) {
                    v = new Vertice(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                } else {
                    v = new Vertice(tokens[0]);
                }
                net.addVertice(v);
            }
            if (sc.hasNext()) {
                nEdges = Integer.parseInt(sc.nextLine().trim());
            }
            for (int i = 0; i < nEdges; i++) {
                tokens = sc.nextLine().trim().split("[ ]+");
                if (tokens.length != 3)
                    continue;
                net.addEdge(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }

}
