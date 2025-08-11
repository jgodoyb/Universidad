package org.ip.sesion03;

import java.util.Scanner;

public class BucleCentinela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero,positivos,negativos,NumPositivos,NumNegativos,cont;	
		Scanner entrada=new Scanner(System.in);
		
	
		numero=1;
		positivos=0;
		NumPositivos=0;
		negativos=0;
		NumNegativos=0;
		cont=0;
	
	
		System.out.println("Introduce valores enteros, el programa termina si la entrada es 0");
		while(numero!=0) {
			numero = entrada.nextInt();
			
			 if(numero>0) {
				 positivos=positivos+numero;
				 NumPositivos++;
				 
		}else 
			if(numero<0) {
				negativos=negativos+numero;
				NumNegativos++;
			}
		cont++;
			 
		 }
		System.out.println("El numero de positivos es "+NumPositivos);
		System.out.println("El numero de negativos es "+NumNegativos);
		System.out.println("El numero total de valores leidos es "+cont);
		System.out.println("La suma de positivos es "+positivos);
		System.out.println("La suma de negativos es "+negativos);
		System.out.print("La media de los valores es "+(((double)(positivos + negativos)/(cont-1))));
		
		entrada.close();
	}

}