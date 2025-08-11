package ual.eda2.practica01;

public class Utilidades {

    public static double distancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public static String format(double d) {
        return String.format("%.10f", d);
    }

    public static void imprimirTiempos(Punto[] puntos){
        long tiempoInicio, tiempoFin;

                                        tiempoInicio = System.nanoTime();
                                        Par mejorFuerzaBrutaSimple = Algoritmos.fuerzaBrutaSimple(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (fuerza bruta simple): \t"
                                                        + mejorFuerzaBrutaSimple + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");

                                        tiempoInicio = System.nanoTime();
                                        Par mejorFuerzaBrutaMejorado = Algoritmos.fuerzaBrutaMejorado(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (fuerza bruta mejorado): \t"
                                                        + mejorFuerzaBrutaMejorado + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");

                                        tiempoInicio = System.nanoTime();
                                        Par divideVencerasSimple = Algoritmos.divideVencerasSimple(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (divide y venceras simple): \t"
                                                        + divideVencerasSimple + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");

                                        tiempoInicio = System.nanoTime();
                                        Par divideVencerasMejorado = Algoritmos.divideVencerasMejorado(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (divide y venceras mejorado): "
                                                        + divideVencerasMejorado + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");

                                        tiempoInicio = System.nanoTime();
                                        Par divideVencerasPro = Algoritmos.divideVencerasPro(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (divide y venceras Pro): \t" + divideVencerasPro
                                                        + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");

                                        tiempoInicio = System.nanoTime();
                                        Par divideVencerasUltra = Algoritmos.divideVencerasUltra(puntos);
                                        tiempoFin = System.nanoTime();
                                        System.out.println("Mejor par (divide y venceras Ultra): \t"
                                                        + divideVencerasUltra + " ("
                                                        + (tiempoFin - tiempoInicio) + "ns)");
    }
    
}
