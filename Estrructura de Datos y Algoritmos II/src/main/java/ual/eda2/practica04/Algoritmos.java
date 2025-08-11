package ual.eda2.practica04;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Algoritmos {
    private static int nivel;
    private static int[] rutaActual;
    private static double valorActual;
    private static int[] asignado;
    private static double[] estimacion;

    /**
     * Resuelve un problema de optimización utilizando un enfoque de backtracking
     * para encontrar el valor mínimo.
     * 
     * Este método explora todas las posibles asignaciones en la matriz dada para
     * encontrar la solución
     * con el valor objetivo mínimo. Utiliza poda basada en estimaciones para evitar
     * explorar ramas
     * que no pueden ofrecer una mejor solución que la actual.
     *
     * @param matriz La matriz de costes que representa el problema a resolver.
     * @return Un objeto {@link Solucion} que contiene la asignación óptima y su
     *         valor.
     */
    public static Solucion backtrackingMin(double[][] matriz) {
        nivel = 0;                       // Empezamos en el nivel 0 (la primera ciudad de la ruta).

        rutaActual = new int[matriz.length];       // 's' es el array que guardará la ruta actual (ej: s = {0, 2, 1, 3}).
        Arrays.fill(rutaActual, -1);               // Lo llenamos con -1 para indicar que no hay ciudades asignadas.
        valorActual = 0;                         // 'bact' es el "valor actual", el coste de la ruta que estamos construyendo. Empieza en 0.

        Solucion sol = new Solucion(rutaActual.length); // 'sol' guardará la mejor solución encontrada hasta ahora.
        sol.setVoA(Double.POSITIVE_INFINITY); // 'voa' es el "valor óptimo actual". Lo ponemos en infinito para que la primera ruta que encontremos sea siempre mejor.
        
        asignado = new int[rutaActual.length];     // 'asignado' es para marcar qué ciudades ya hemos metido en la ruta 's'.
        estimacion = calcularEstimacion(matriz, true); // ¡Muy importante! Una estimación del coste mínimo restante. 
        do {
            generar(matriz, sol);
            if (solucion() && valorActual < sol.getVoA()) {//Verifica si la ruta actual es una solución válida y si su coste es menor que el mejor encontrado.
                // Si es una solución válida y su coste es menor que el mejor encontrado, actualiza la solución.
                sol.setVoA(valorActual);
                sol.setSoa(rutaActual);
            }

            if (nivel < rutaActual.length - 1 && criterio() && valorActual + estimacion[nivel] < sol.getVoA()) {
                nivel++;
            } else {
                while (nivel > -1 && !masHermanos()) {
                    retroceder(matriz);
                }
            }
        } while (nivel > -1);
        return sol;
    }

    /**
     * Resuelve un problema de optimización utilizando el algoritmo de backtracking
     * para encontrar el valor máximo
     * basado en la matriz proporcionada. El método explora todas las posibles
     * soluciones, podando aquellas ramas
     * que no pueden ofrecer una mejor solución que la mejor encontrada hasta el
     * momento.
     *
     * @param matriz Una matriz bidimensional de doubles que representa los datos o
     *               la matriz de costes del problema.
     * @return Un objeto {@link Solucion} que contiene la mejor solución encontrada
     *         y su valor asociado.
     */
    public static Solucion backtrackingMax(double[][] matriz) {
        nivel = 0;
        rutaActual = new int[matriz.length];
        Arrays.fill(rutaActual, -1);
        valorActual = 0;
        Solucion sol = new Solucion(rutaActual.length);
        sol.setVoA(Double.NEGATIVE_INFINITY);
        asignado = new int[rutaActual.length];
        estimacion = calcularEstimacion(matriz, false);
        do {
            generar(matriz, sol);
            if (solucion() && valorActual > sol.getVoA()) {
                sol.setVoA(valorActual);
                sol.setSoa(rutaActual);
            }
            if (nivel < rutaActual.length - 1 && criterio() && valorActual + estimacion[nivel] > sol.getVoA()) {
                nivel++;
            } else {
                while (nivel > -1 && !masHermanos()) {
                    retroceder(matriz);
                }
            }
        } while (nivel > -1);
        return sol;
    }

    /**
     * Resuelve un problema de optimización utilizando la técnica de Branch and
     * Bound para encontrar la solución mínima.
     * 
     * Este método explora el espacio de soluciones generando nodos que representan
     * soluciones parciales,
     * y utiliza una cola de prioridad para expandir siempre el nodo más prometedor
     * primero (el de menor coste estimado).
     * En cada nivel, genera nuevos nodos intercambiando elementos y calculando el
     * nuevo coste acumulado.
     * La búsqueda se poda utilizando una función de estimación: los nodos cuyo
     * coste total estimado supera la mejor
     * solución encontrada hasta el momento no se expanden.
     * 
     * @param matriz La matriz de costes que representa la instancia del problema.
     * @return Un objeto {@link Solucion} que contiene el coste mínimo encontrado y
     *         la solución correspondiente.
     */
    public static Solucion branchAndBoundMin(double[][] matriz) {
        int n = matriz.length;
        nivel = 0;
        rutaActual = new int[n];
        valorActual = 0;
        for (int i = 0; i < n; i++) {
            rutaActual[i] = i;
            valorActual += matriz[i][i];
        }
        Solucion sol = new Solucion(n);
        sol.setVoA(valorActual);
        sol.setSoa(rutaActual);
        valorActual = 0;
        estimacion = calcularEstimacion(matriz, true);
        PriorityQueue<Nodo> LNV = new PriorityQueue<>();
        LNV.add(new Nodo(nivel, rutaActual, valorActual, estimacion[nivel]));

        while (!LNV.isEmpty()) {
            Nodo nodo = LNV.poll();
            nivel = nodo.getNivel();
            rutaActual = nodo.getS();
            valorActual = nodo.getBact();

            if (nivel == n) {
                if (valorActual < sol.getVoA()) {
                    sol.setSoa(rutaActual);
                    sol.setVoA(valorActual);
                }
            } else {
                int[] copia = rutaActual.clone();
                for (int i = nivel; i < n; i++) {
                    swap(copia, i, nivel);
                    double newbact = valorActual + matriz[nivel][copia[nivel]];
                    double newEstimacion = newbact + estimacion[nivel];
                    if (newEstimacion < sol.getVoA()) {
                        LNV.add(new Nodo(nivel + 1, copia, newbact, newEstimacion));
                    }
                }
            }
        }
        return sol;
    }

    /**
     * Resuelve un problema de asignación utilizando el algoritmo Branch and Bound
     * para maximizar el valor total.
     * <p>
     * Dada una matriz cuadrada donde cada elemento representa el valor de asignar
     * una tarea (fila) a un agente (columna),
     * este método encuentra la asignación que proporciona el valor total máximo.
     * Utiliza una cola de prioridad para explorar
     * las posibles asignaciones, podando aquellas ramas que no pueden superar la
     * mejor solución encontrada hasta el momento.
     * </p>
     *
     * @param matriz una matriz cuadrada de doubles que representa el valor de
     *               asignar cada tarea a cada agente
     * @return un objeto {@link Solucion} que contiene la asignación óptima y su
     *         valor total
     */
    public static Solucion branchAndBoundMax(double[][] matriz) {
        int n = matriz.length;
        nivel = 0;
        rutaActual = new int[n];
        valorActual = 0;
        for (int i = 0; i < n; i++) {
            rutaActual[i] = i;
            valorActual += matriz[i][i];
        }
        Solucion sol = new Solucion(n);
        sol.setVoA(valorActual);
        sol.setSoa(rutaActual);
        valorActual = 0;
        estimacion = calcularEstimacion(matriz, false);
        PriorityQueue<Nodo> LNV = new PriorityQueue<>();
        LNV.add(new Nodo(nivel, rutaActual, valorActual, estimacion[nivel]));

        while (!LNV.isEmpty()) {
            Nodo nodo = LNV.poll();
            nivel = nodo.getNivel();
            rutaActual = nodo.getS();
            valorActual = nodo.getBact();

            if (nivel == n) {
                if (valorActual > sol.getVoA()) {
                    sol.setSoa(rutaActual);
                    sol.setVoA(valorActual);
                }
            } else {
                int[] copia = rutaActual.clone();
                for (int i = nivel; i < n; i++) {
                    swap(copia, i, nivel);
                    double newbact = valorActual + matriz[nivel][copia[nivel]];
                    double newEstimacion = newbact + estimacion[nivel];
                    if (newEstimacion > sol.getVoA()) {
                        LNV.add(new Nodo(nivel + 1, copia, newbact, newEstimacion));
                    }
                }
            }
        }
        return sol;
    }

    /**
     * Devuelve el valor mínimo en el array de doubles especificado.
     *
     * @param a el array de valores double en el que buscar el mínimo
     * @return el valor más pequeño encontrado en el array; devuelve
     *         {@link Double#POSITIVE_INFINITY} si el array está vacío
     */
    private static double min(double[] a) {
        Double min = Double.POSITIVE_INFINITY;
        for (double d : a) {
            if (d < min)
                min = d;
        }
        return min;
    }

    /**
     * Devuelve el valor máximo en el array de doubles especificado.
     *
     * @param a el array de valores double en el que buscar el máximo
     * @return el valor más grande encontrado en el array; devuelve
     *         {@link Double#NEGATIVE_INFINITY} si el array está vacío
     */
    public static double max(double[] a) {
        Double max = Double.NEGATIVE_INFINITY;
        for (double d : a) {
            if (d > max)
                max = d;
        }
        return max;
    }

    /**
     * /**
     * Actualiza la asignación y el valor acumulado para el nivel actual en la
     * matriz.
     *
     * Este método incrementa el índice de asignación para el nivel actual y ajusta
     * el valor acumulado.
     *
     * @param matriz La matriz de costes utilizada para calcular el valor acumulado.
     */
    public static void generar(double[][] matriz) {
        if (rutaActual[nivel] >= 0)
            asignado[rutaActual[nivel]]--;
        rutaActual[nivel]++;
        asignado[rutaActual[nivel]]++;
        if (rutaActual[nivel] == 0) {
            valorActual += matriz[nivel][rutaActual[nivel]];
        } else {
            valorActual += matriz[nivel][rutaActual[nivel]] - matriz[nivel][rutaActual[nivel] - 1];
        }
    }

    /**
     * Actualiza la solución actual incrementando la asignación en el nivel actual,
     * actualizando el conteo de asignados y ajustando el coste acumulado según la
     * matriz proporcionada.
     *
     * @param matriz La matriz de costes que representa la instancia del problema.
     * @param sol    El objeto solución que se está construyendo o modificando.
     *
     *               Nota: Este método asume la existencia de variables externas
     *               como 'nivel', 's', 'asignado' y 'bact'.
     *               Incrementa la asignación en el nivel actual, actualiza el
     *               conteo de asignados
     *               y modifica el coste acumulado en consecuencia.
     */
    public static void generar(double[][] matriz, Solucion sol) {
        if (rutaActual[nivel] >= 0)
            asignado[rutaActual[nivel]]--;
        rutaActual[nivel]++;
        asignado[rutaActual[nivel]]++;
        if (rutaActual[nivel] == 0) {
            valorActual += matriz[nivel][rutaActual[nivel]];
        } else {
            valorActual += matriz[nivel][rutaActual[nivel]] - matriz[nivel][rutaActual[nivel] - 1];
        }
    }

    /**
     * Determina si existen más hermanos en el nivel actual.
     *
     * @return {@code true} si el índice actual en el nivel dado es menor que el
     *         índice máximo (es decir, hay más hermanos);
     *         {@code false} en caso contrario.
     */
    public static boolean masHermanos() {
        return rutaActual[nivel] < rutaActual.length - 1;
    }

    /**
     * Determina si el estado actual representa una solución válida.
     * <p>
     * Una solución es válida si se ha llegado al último nivel y se cumple el
     * criterio de asignación.
     * </p>
     *
     * @return {@code true} si el estado actual es una solución válida,
     *         {@code false} en caso contrario.
     */
    private static boolean solucion() {
        return nivel == rutaActual.length - 1 && criterio();
    }

    /**
     * Retrocede al nivel anterior, actualizando el valor acumulado y la asignación.
     * Este método se utiliza para deshacer la última asignación y volver al estado
     * anterior en la búsqueda.
     *
     * @param matriz La matriz de costes utilizada para calcular el valor acumulado.
     */
    private static void retroceder(double[][] matriz) {
        valorActual -= matriz[nivel][rutaActual[nivel]];
        asignado[rutaActual[nivel]]--;
        rutaActual[nivel] = -1;
        nivel--;
    }

    /**
     * Verifica si el criterio de asignación se cumple para el nivel actual.
     * <p>
     * El criterio se cumple si el elemento asignado en el nivel actual ha sido
     * asignado al menos una vez.
     * </p>
     *
     * @return {@code true} si el criterio se cumple, {@code false} en caso
     *         contrario.
     */
    private static boolean criterio() {
        return asignado[rutaActual[nivel]] == 1;
    }

    /**
     * Calcula un array de estimaciones basado en la matriz proporcionada y el
     * objetivo de optimización.
     * Para cada fila (empezando desde la penúltima hacia arriba), calcula la
     * estimación sumando el valor
     * mínimo o máximo (según el parámetro 'minimizar') de la siguiente fila a la
     * estimación de la siguiente fila.
     *
     * @param matriz    Matriz bidimensional de doubles que representa los datos de
     *                  entrada.
     * @param minimizar Si es true, utiliza el valor mínimo de la siguiente fila
     *                  para la estimación;
     *                  si es false, utiliza el valor máximo.
     * @return Un array de doubles con las estimaciones calculadas para cada fila.
     */
    private static double[] calcularEstimacion(double[][] matriz, boolean minimizar) {
        double[] estimacion = new double[matriz.length];
        for (int i = rutaActual.length - 2; i >= 0; i--) {
            estimacion[i] = (minimizar ? min(matriz[i + 1]) : max(matriz[i + 1])) + estimacion[i + 1];
        }
        return estimacion;
    }

    /**
     * Intercambia los elementos en las posiciones especificadas del array dado.
     *
     * @param a el array en el que se intercambiarán los elementos
     * @param i el índice del primer elemento a intercambiar
     * @param j el índice del segundo elemento a intercambiar
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
