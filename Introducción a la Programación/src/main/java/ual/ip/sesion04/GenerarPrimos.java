package org.ip.sesion04;

public class GenerarPrimos {

	public static boolean esPrimo(int numero) {

		boolean primo=true;
		int i=2;
		while(i<=Math.sqrt(numero) && primo==true) {
			if(numero % i == 0) {
				primo=false;
				
			}else
				i++;
		}
		return primo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int contador=0;
		
		System.out.println("Los 50 primeros numeros primos son: \n");
		for(int numero=2;contador<50;numero++) {
			
			if(GenerarPrimos.esPrimo(numero)==true) {
				System.out.print("\t"+numero);
				contador++;
				if(contador%10==0) {
					System.out.println();

				}
			}
		}
	}

	}
