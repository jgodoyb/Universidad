package ejercicios.ejercicio1;
import java.util.ArrayList;
import java.util.Iterator;

public class EstiloRemaster {

    public static void main(String[] args) {

        // Ejercicio 1 y 2: Crear una lista de números aleatorios ---
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            arr.add(String.valueOf(Math.random() < 0.5 ? i : -i));
        }

        System.out.println("Lista Original Creada");
        System.out.println(arr.toString());

        // Ejercicio 3: Contar números negativos: El objetivo es comparar las diferentes formas de recorrer un bucle.

        System.out.println("Ejercicio 3: Contando negativos de 3 formas");
        int contadorNegativos1 = 0;
        int contadorNegativos2 = 0;
        int contadorNegativos3 = 0;

        // Forma 1: Usando un for tradicional
        for (int i = 0; i < arr.size(); i++) {
            if (Integer.valueOf(arr.get(i)) < 0) {
                contadorNegativos1++;
            }
        }

        // Forma 2: Usando un iterator
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            if (Integer.valueOf(it.next()) < 0) {
                contadorNegativos2++;
            }
        }

        // Forma 3: Usando un for-each (generalmente la más legible)
        for (String s : arr) {
            if (Integer.valueOf(s) < 0) {
                contadorNegativos3++;
            }
        }

        System.out.println("Resultado con for tradicional: " + contadorNegativos1);
        System.out.println("Resultado con iterator: " + contadorNegativos2);
        System.out.println("Resultado con for-each: " + contadorNegativos3);

        // Ejercicios 5, 6 y 7: Encontrar el primer negativo
        // Estos ejercicios buscan el primer negativo en la lista original,
        // antes de que sea modificada.

        System.out.println("Ejercicios 5, 6 y 7: Buscando el primer negativo");

        // Ejercicio 5: Usando for-each con 'continue' y 'break'
        System.out.print("Resultado Ejercicio 5 (for-each): ");
        for (String s : arr) {
            if (Integer.valueOf(s) >= 0) {
                continue; // Si es positivo, salta a la siguiente iteración
            }
            System.out.println("Se ha encontrado un número negativo: " + s);
            break; // Termina el bucle al encontrar el primero
        }

        // Ejercicio 6: Usando un while(true)
        System.out.print("Resultado Ejercicio 6 (while): ");
        int i = 0;
        while (i < arr.size()) {
            if (Integer.valueOf(arr.get(i)) < 0) {
                System.out.println("Se ha encontrado un número negativo: " + arr.get(i));
                break;
            }
            i++;
        }

        // Ejercicio 7: Versión mejorada del while
        System.out.print("Resultado Ejercicio 7 (while mejorado): ");
        int j = 0;
        while (true) {
            if (j == arr.size()) {
                System.out.println("No se ha encontrado ningún número negativo.");
                break;
            }
            if ((Integer.valueOf(arr.get(j))) >= 0) {
                j++;
                continue;
            }
            System.out.println("Se ha encontrado un número negativo: " + arr.get(j));
            break;
        }


        // Ejercicio 4: Convertir negativos a positivos
        // Este es el último paso. Se modifica la lista, convirtiendo todos los valores negativos en sus equivalentes positivos.

        System.out.println("Ejercicio 4: Convirtiendo negativos a positivos");
        for (int k = 0; k < arr.size(); k++) {
            int valor = Integer.parseInt(arr.get(k));
            if (valor < 0) {
                arr.set(k, String.valueOf(-valor));
            }
        }
        System.out.println("Lista final con solo números positivos:");
        System.out.println(arr.toString());

    }
}