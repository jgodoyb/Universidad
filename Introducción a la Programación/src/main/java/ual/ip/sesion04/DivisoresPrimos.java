package org.ip.sesion04;

import java.util.Scanner;

public class DivisoresPrimos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner pant = new Scanner(System.in);

		int numero;
		System.out.print("Introduzca un numero: ");
		numero = pant.nextInt();
		DivisoresPrimos.divisoresPrimos(numero);
		pant.close();
	}

	public static void divisoresPrimos(int numero) {

		System.out.print("Los divisores primos de " + numero + " son: ");
		for (int i = 2; i <= numero; i++)
			if (esPrimo(i) && numero %i== 0) {
				System.out.print(i + " ");

			}
	}

	public static boolean esPrimo(int numero) {

		boolean primo = true;
		int i = 3;
		if (((numero % 2) == 0) && (numero != 2)) {
			primo = false;
		}
		while (primo && i <= (Math.sqrt(numero))) {
			if(numero %i==0) {
				primo = false;
			}
			i += 2;
		}
		return primo;
	}

}
