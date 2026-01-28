package ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;

public class Estilo {

    public static void main(String[] args) {


        //Ejericios 1: Crear un ArrayList de 50 numeros que de manera radom sea positivo o negativo
        ArrayList<String> arr = new ArrayList<String>();
        for ( int i=0; i < 50; i++ ) {
            if(Math.random() < 0.5) {
                arr.add(String.valueOf(i));
            } else {
                arr.add(String.valueOf(-i));
            }
        }

        System.out.println(arr.toString());


        //Ejercicio 2: Hacer lo mismo pero usando el operador ternario
        for (int i = 0; i < 50; i++) {
            arr.add(String.valueOf(Math.random() < 0.5 ? i : -i)); 
        }
        System.out.println(arr.toString());


        //Ejercicio 3:
        //Ahora lo se hace es contar el numero de negativos que hay en el arraylist, y se hace de maneras distintas, algunas mejores que otras
        //El objetivo es ver cual es la mejor forma de hacerlo

        int contadorNegativos1 = 0;
        int contadorNegativos2 = 0;
        int contadorNegativos3 = 0;

        //Forma 1: Usando un for tradicional
        for (int i = 0; i < arr.size(); i++) {
            if (Integer.valueOf(arr.get(i)) < 0){ contadorNegativos1++; 
            }
        }

        //Forma 2: Usando un iterator, esta es peor forma
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            if (Integer.valueOf(it.next()) < 0) { contadorNegativos2++; 
            }
        }

        //Forma 3: Usando un for-each, se supone que es la mejor forma
        for (String s : arr) {
            if (Integer.valueOf(s) < 0) { contadorNegativos3++; 
            }
        }


        System.out.println("\n El número de elementos negativos según la forma 2 : " + contadorNegativos2);
        System.out.println("\n El número de elementos negativos según la forma 3 : " + contadorNegativos3);
        System.out.println("\n El número de elementos negativos según la forma 1 : " + contadorNegativos1);
        System.out.println(arr.toString());



        //Ejercicio 4: Si encuentra un numero negativo que lo trasforme a un positivo
        
        for(int i=0; i < arr.size(); i++) {
            if (Integer.valueOf(arr.get(i)) < 0) arr.set(i, String.valueOf(-Integer.valueOf(arr.get(i))));
        }
        System.out.println(arr.toString());


        //Ejercicio 5: Recorrer la estrucutura y el momento en que se encuentra un valor negativo se indique en pantalla y se salga del bucle

        for (String s : arr) {
            if (Integer.valueOf(s) >= 0) { continue;
            }
            System.out.println("Se ha encontrado un numero negativo: " + s);
            break;   
        }

        //Ejericio 6: Hacer lo mismo que el anterior pero haciendo de un while siendo true
        int i=0;
        while(true){
            if(Integer.valueOf(arr.get(i)) < 0) {
                System.out.println("Se ha encontrado un numero negativo: " + arr.get(i));
                break;
            }
            i++;

        }

        //Ejercicio 7: Hacer lo mismo que el anterior pero mejorado
        int j=0;
        while(true){
            if(j == arr.size()) {
                System.out.println("No se ha encontrado ningun numero negativo");
                break;
            }
            if((Integer.valueOf(arr.get(j))) >= 0) {
                j++;
                continue;
            }
            System.out.println("Se ha encontrado un numero negativo: " + arr.get(j));
            break;
        }

    }
}

//En esta clase se emplean metodos intersantes como el String.valueOf() el cual permite convertir encapsular un valor y convertirlo en String
//Y luego es la forma de simplificar el codigo con el operador ternario en lugar de usar un if-else