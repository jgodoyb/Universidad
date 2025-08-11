package ual.eda2.practica01;

import java.util.Arrays;

public class Algoritmos {

    /**
     * Encuentra el par de puntos más cercano en un array de puntos utilizando el
     * método de fuerza bruta.
     * 
     * @param puntos Un array de objetos Punto que representa los puntos a evaluar.
     * @return Un objeto Par que contiene los dos puntos más cercanos y la distancia
     *         entre ellos.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par fuerzaBrutaSimple(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Par mejor = new Par();
        for (int i = 0; i < puntos.length; i++) {
            for (int j = 0; j < puntos.length; j++) {
                if (i == j)
                    continue;
                double distancia = Utilidades.distancia(puntos[i], puntos[j]);
                if (distancia < mejor.getDistancia()) {
                    mejor = new Par(puntos[i], puntos[j], distancia);
                }
            }
        }
        return mejor;
    }

    /**
     * Encuentra el par de puntos más cercano en un array de puntos utilizando un
     * algoritmo de fuerza bruta mejorado.
     *
     * @param puntos Un array de objetos Punto que representa los puntos en el
     *               espacio.
     * @return Un objeto Par que contiene los dos puntos más cercanos y la distancia
     *         entre ellos.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par fuerzaBrutaMejorado(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Par mejor = new Par();
        for (int i = 0; i < puntos.length - 1; i++) {
            for (int j = i + 1; j < puntos.length; j++) {
                double distancia = Utilidades.distancia(puntos[i], puntos[j]);
                if (distancia < mejor.getDistancia()) {
                    mejor = new Par(puntos[i], puntos[j], distancia);
                }
            }
        }
        return mejor;
    }

    /**
     * Método que implementa el algoritmo de Divide y Vencerás para encontrar el par
     * de puntos más cercano.
     * 
     * @param puntos Array de puntos a procesar.
     * @return Par de puntos más cercano.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par divideVencerasSimple(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Punto[] copiaPuntos = Arrays.copyOf(puntos, puntos.length); // Método para hacer la copia de los puntos al nuevo
                                                                    // array.
        Arrays.sort(copiaPuntos, new XYComparator());
        Par mejor = comprobarRepetidos(copiaPuntos);
        if (mejor != null) {
            return mejor;
        }

        return divideVencerasSimple(copiaPuntos, 0, copiaPuntos.length - 1);

    }

    /**
     * Este método implementa el enfoque de divide y vencerás para encontrar el par
     * de puntos más cercano en un array dado de puntos.
     * 
     * @param puntos Un array de objetos Punto que representa los puntos.
     * @param inicio El índice de inicio del subarray a considerar.
     * @param fin    El índice de fin del subarray a considerar.
     * @return Un objeto Par que representa el par de puntos más cercano y su
     *         distancia.
     * 
     *         El método funciona de la siguiente manera:
     *         - Caso Base: Si el número de puntos en el subarray es menor o igual a
     *         3, calcula la distancia entre cada par de puntos y devuelve el par
     *         más cercano.
     *         - Caso Recursivo: Divide el array en dos mitades, encuentra
     *         recursivamente el par más cercano en cada mitad y luego combina los
     *         resultados para encontrar el par más cercano entre las dos mitades.
     *         - Combinación: Verifica las distancias entre puntos en la mitad
     *         izquierda y puntos en la mitad derecha para asegurar que se encuentra
     *         el par más cercano.
     */
    private static Par divideVencerasSimple(Punto[] puntos, int inicio, int fin) {
        // CASO BASE
        Par mejor = new Par();
        if (fin - inicio <= 3) {
            for (int i = inicio; i < fin; i++) {
                for (int j = i + 1; j <= fin; j++) {
                    double d = Utilidades.distancia(puntos[i], puntos[j]);
                    if (d < mejor.getDistancia()) {
                        mejor = new Par(puntos[i], puntos[j], d);
                    }
                }
            }
            return mejor;
        }

        // CASO RECURSIVO
        int mitad = (inicio + fin) / 2;
        Par izquierda = divideVencerasSimple(puntos, inicio, mitad);
        Par derecha = divideVencerasSimple(puntos, mitad + 1, fin);
        mejor = izquierda.getDistancia() < derecha.getDistancia() ? izquierda : derecha; // Esto va a actuar como un
                                                                                         // delta

        // COMBINAR
        for (int i = inicio; i <= mitad; i++) {
            for (int j = mitad + 1; j <= fin; j++) {
                double d = Utilidades.distancia(puntos[i], puntos[j]);
                if (d < mejor.getDistancia()) {
                    mejor = new Par(puntos[i], puntos[j], d);
                }
            }
        }
        return mejor;

    }

    /**
     * Método que encuentra el par de puntos más cercano utilizando el algoritmo de
     * divide y vencerás mejorado.
     *
     * @param puntos Array de puntos a evaluar.
     * @return Par de puntos más cercano.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par divideVencerasMejorado(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Punto[] copiaPuntos = Arrays.copyOf(puntos, puntos.length); // Método para hacer la copia de los puntos al nuevo
                                                                    // array.
        Arrays.sort(copiaPuntos, new XYComparator());
        Par mejor = comprobarRepetidos(copiaPuntos);
        if (mejor != null) {
            return mejor;
        }

        return divideVencerasMejorado(copiaPuntos, 0, copiaPuntos.length - 1);

    }

    /**
     * Este método implementa el enfoque de divide y vencerás para encontrar el par
     * de puntos más cercano en un array dado de puntos.
     * Divide recursivamente el array en dos mitades, encuentra el par más cercano
     * en cada mitad y luego combina los resultados
     * para encontrar el par más cercano en general.
     *
     * @param puntos Un array de objetos Punto que representa los puntos.
     * @param inicio El índice de inicio del segmento del array a procesar.
     * @param fin    El índice de fin del segmento del array a procesar.
     * @return Un objeto Par que representa el par de puntos más cercano y su
     *         distancia.
     */
    private static Par divideVencerasMejorado(Punto[] puntos, int inicio, int fin) {
        // CASO BASE
        Par mejor = new Par();
        if (fin - inicio <= 3) {
            for (int i = inicio; i < fin; i++) {
                for (int j = i + 1; j <= fin; j++) {
                    double d = Utilidades.distancia(puntos[i], puntos[j]);
                    if (d < mejor.getDistancia()) {
                        mejor = new Par(puntos[i], puntos[j], d);
                    }
                }
            }
            return mejor;
        }

        // CASO RECURSIVO
        int mitad = (inicio + fin) / 2;
        Par izquierda = divideVencerasMejorado(puntos, inicio, mitad);
        Par derecha = divideVencerasMejorado(puntos, mitad + 1, fin);
        mejor = izquierda.getDistancia() < derecha.getDistancia() ? izquierda : derecha; // Esto va a actuar como un
                                                                                         // delta

        // COMBINAR
        for (int i = mitad; i >= inicio && puntos[i].getX() > puntos[mitad].getX() - mejor.getDistancia(); i--) {
            for (int j = mitad + 1; j <= fin && puntos[j].getX() < puntos[mitad].getX() + mejor.getDistancia(); j++) {
                double d = Utilidades.distancia(puntos[i], puntos[j]);
                if (d < mejor.getDistancia()) {
                    mejor = new Par(puntos[i], puntos[j], d);
                }
            }
        }
        return mejor;

    }

    // n cuadrado en todas las versiones, pero en la última versión se reduce a n
    // log n

    /**
     * Método que implementa el algoritmo de Divide y Vencerás para encontrar el par
     * de puntos más cercano.
     * 
     * @param puntos Array de puntos a procesar.
     * @return Par de puntos más cercano.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par divideVencerasPro(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Punto[] copiaPuntos = Arrays.copyOf(puntos, puntos.length); // Método para hacer la copia de los puntos al nuevo
                                                                    // array.
        Arrays.sort(copiaPuntos, new XYComparator());
        Par mejor = comprobarRepetidos(copiaPuntos);
        if (mejor != null) {
            return mejor;
        }

        return divideVencerasPro(copiaPuntos, 0, copiaPuntos.length - 1);

    }

    /**
     * /**
     * Este método implementa el enfoque de divide y vencerás para encontrar el par
     * de puntos más cercano en un array dado de puntos.
     * 
     * @param puntos Un array de objetos Punto que representa los puntos.
     * @param inicio El índice de inicio del subarray a considerar.
     * @param fin    El índice de fin del subarray a considerar.
     * @return Un objeto Par que representa el par de puntos más cercano y su
     *         distancia.
     */
    private static Par divideVencerasPro(Punto[] puntos, int inicio, int fin) {
        // CASO BASE
        Par mejor = new Par();
        if (fin - inicio <= 3) {
            for (int i = inicio; i < fin; i++) {
                for (int j = i + 1; j <= fin; j++) {
                    double d = Utilidades.distancia(puntos[i], puntos[j]);
                    if (d < mejor.getDistancia()) {
                        mejor = new Par(puntos[i], puntos[j], d);
                    }
                }
            }
            return mejor;
        }

        // CASO RECURSIVO
        int mitad = (inicio + fin) / 2;
        Par izquierda = divideVencerasPro(puntos, inicio, mitad);
        Par derecha = divideVencerasPro(puntos, mitad + 1, fin);
        mejor = izquierda.getDistancia() < derecha.getDistancia() ? izquierda : derecha; // Esto va a actuar como un
                                                                                         // delta
        Punto[] franja = new Punto[fin - inicio + 1];
        int k = 0;

        // COMBINAR
        for (int i = mitad; i >= inicio && puntos[i].getX() > puntos[mitad].getX() - mejor.getDistancia(); i--) {
            franja[k] = puntos[i];
            k++;
        }
        for (int i = mitad + 1; i <= fin && puntos[i].getX() < puntos[mitad].getX() + mejor.getDistancia(); i++) {
            franja[k] = puntos[i];
            k++;
        }

        Arrays.sort(franja,0, k, new YComparator());
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k && franja[j].getY() - franja[i].getY() < mejor.getDistancia(); j++) {
                double d = Utilidades.distancia(franja[i], franja[j]);
                if (d < mejor.getDistancia()) {
                    mejor = new Par(franja[i], franja[j], d);
                }
            }
        }

        return mejor;

    }

    /**
     * Método que implementa el algoritmo de Divide y Vencerás para encontrar el par
     * de puntos más cercano.
     * 
     * @param puntos Array de puntos a procesar.
     * @return Par de puntos más cercano.
     * @throws IllegalArgumentException Si el array de puntos es nulo o tiene menos
     *                                  de dos elementos.
     */
    public static Par divideVencerasUltra(Punto[] puntos) {
        if (puntos == null)
            throw new IllegalArgumentException("El array de puntos no puede ser nulo");
        if (puntos.length < 2)
            throw new IllegalArgumentException("El array de puntos debe tener al menos dos elementos");

        Punto[] px = Arrays.copyOf(puntos, puntos.length);
        Punto[] py = new Punto[puntos.length];
        Arrays.sort(px, new YComparator());
        Arrays.sort(px, new XComparator());

        Par mejor = comprobarRepetidos(px);
        if (mejor != null) {
            return mejor;
        }

        py = Arrays.copyOf(px, px.length);
        Punto[] auxiliarPuntos = new Punto[puntos.length];

        return divideVencerasUltra(px, py, auxiliarPuntos, 0, px.length - 1);

    }

    /**
     * /**
     * Este método implementa el enfoque de divide y vencerás para encontrar el par
     * de puntos más cercano en un array dado de puntos.
     * 
     * @param puntos Un array de objetos Punto que representa los puntos.
     * @param inicio El índice de inicio del subarray a considerar.
     * @param fin    El índice de fin del subarray a considerar.
     * @return Un objeto Par que representa el par de puntos más cercano y su
     *         distancia.
     */
    private static Par divideVencerasUltra(Punto[] px, Punto[] py, Punto[] auxiliarPuntos, int inicio, int fin) {
        // CASO BASE
        Par mejor = new Par();
        if (inicio >= fin) {
            return mejor;
        }

        // CASO RECURSIVO
        int mitad = (inicio + fin) / 2;
        Par izquierda = divideVencerasUltra(px, py, auxiliarPuntos, inicio, mitad);
        Par derecha = divideVencerasUltra(px, py, auxiliarPuntos, mitad + 1, fin);
        mejor = (izquierda.getDistancia() < derecha.getDistancia()) ? izquierda : derecha;

        mix(py, auxiliarPuntos, inicio, mitad, fin);
        int k = 0;

        for (int i = inicio; i <= fin; i++) {
            if (Math.abs(py[i].getX() - px[mitad].getX()) < mejor.getDistancia()) {
                auxiliarPuntos[k] = py[i];
                k++;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < (k - 1)
                    && (auxiliarPuntos[j].getY() - auxiliarPuntos[i].getY()) < mejor.getDistancia(); j++) {
                double d = Utilidades.distancia(auxiliarPuntos[i], auxiliarPuntos[j]);
                if (d < mejor.getDistancia()) {
                    mejor = new Par(auxiliarPuntos[i], auxiliarPuntos[j], d);
                }
            }
        }

        return mejor;

    }

    /**
     * Mezcla dos subarreglos de puntos ordenados por la coordenada Y en un solo
     * arreglo ordenado.
     *
     * @param py             El arreglo de puntos a mezclar.
     * @param auxiliarPuntos Un arreglo auxiliar para almacenar temporalmente los
     *                       puntos.
     */
    private static void mix(Punto[] py, Punto[] auxiliarPuntos, int inicio, int mitad, int fin) {
        Punto[] temp = Arrays.copyOfRange(py, inicio, fin + 1);
        int i = 0;
        int j = (mitad + 1) - inicio;

        for (int k = inicio; k <= fin; k++) {
            if (i > (mitad - inicio)) {
                py[k] = temp[j++];
            } else if (j > (fin - inicio)) {
                py[k] = temp[i++];
            } else if (temp[j].getY() < temp[i].getY()) {
                py[k] = temp[j++];
            } else {
                py[k] = temp[i++];
            }
        }

    }

    /**
     * Verifica si hay puntos repetidos en el array dado de puntos.
     *
     * @param copiaPuntos un array de objetos Punto a verificar si hay duplicados.
     * @return un objeto Par que contiene el primer par de puntos repetidos
     *         encontrados y una distancia de 0,
     *         o null si no se encuentran puntos repetidos.
     */
    private static Par comprobarRepetidos(Punto[] copiaPuntos) {
        for (int i = 0; i < copiaPuntos.length - 1; i++) {
            if (copiaPuntos[i].equals(copiaPuntos[i + 1])) {
                return new Par(copiaPuntos[i], copiaPuntos[i + 1], 0);
            }

        }
        return null;
    }

}
