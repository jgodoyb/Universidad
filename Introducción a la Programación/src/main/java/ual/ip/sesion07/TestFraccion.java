package org.ip.sesion07;

import java.util.Scanner;

import org.ip.sesion08.Fraccion;

public class TestFraccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numComp=0;
		int numerador,denominador,numerador2,denominador2;
		
		Scanner a=new Scanner(System.in);
		
		System.out.println("Cuantas comparaciones de fracciones deseas realizar?");
		numComp=a.nextInt();
		for(int i=1;i<=numComp;i++) {
			System.out.println("Comparacion " +i);
			System.out.println("Introduce numerador y denominador de la primera fraccion");
			numerador=a.nextInt();
			denominador=a.nextInt();
			Fraccion frac1= new Fraccion(numerador,denominador);
			System.out.println("Introduce numerador y denominador de la segunda fraccion");
			numerador2=a.nextInt();
			denominador2=a.nextInt();
			Fraccion frac2=new Fraccion(numerador2,denominador2);
			
			switch(frac1.compareTo(frac2)) {
			case 1:
				System.out.println(frac1+" es mayor que "+frac2);
				break;
			case 0:
				System.out.println(frac1+" es igual que "+frac2);
				break;
			case -1:
				System.out.println(frac1+" es menor que "+frac2);
			}
			
			System.out.println();
		}
		
		a.close();
		}

	}


