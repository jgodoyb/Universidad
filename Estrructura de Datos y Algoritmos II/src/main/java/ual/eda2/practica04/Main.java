package ual.eda2.practica04;

public class Main {
    public static void main(String[] args) {
        double[][] matriz = { { 4, 9, 1 }, { 7, 2, 3 }, { 6, 3, 5 } };
        Solucion sol1 = Algoritmos.backtrackingMin(matriz);
        System.out.println(sol1);
        Solucion sol2 = Algoritmos.backtrackingMax(matriz);
        System.out.println(sol2);
        Solucion sol3 = Algoritmos.branchAndBoundMin(matriz);
        System.out.println(sol3);
        Solucion sol4 = Algoritmos.branchAndBoundMax(matriz);
        System.out.println(sol4);
    }
}
