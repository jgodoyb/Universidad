package org.ip.sesion06;

import java.util.Scanner;

import java.util.Locale;

public class TestCirculo {

	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in) ;
		entrada.useLocale(Locale.ENGLISH);
		
		Circulo circ1=new Circulo(1.0,1.0,1.0);
		Circulo circ2=new Circulo();
		Circulo circ3=new Circulo(0.0,0.0);
		Circulo circ4=new Circulo(circ3);
		
		System.out.println("*** Programa que permite trabajar con circulos *** \n");
		System.out.println("Circulo 1 "+circ1.toString());
		System.out.println("Circulo 2 "+circ2.toString());
		System.out.println("Circulo 3 "+circ3.toString());
		System.out.println("Circulo 4 "+circ4.toString());
		if(circ1.equals(circ2)) {
			System.out.println("Circulos 1 y 2 son iguales");
		}else {
			System.out.println("Circulos 1 y 2 son distintos");
		}
		if(circ2.equals(circ3) && circ3.equals(circ4)) {
			System.out.println("Circulos 2, 3 y 4 son iguales");
		}else {
			System.out.println("Circulos 2,3 y 4 son distintos");
		}
		System.out.println("El numero de circulos creados es "+Circulo.getNumCirculos());
		switch(circ1.compareTo(circ2)) {
		case -1:
			System.out.println("Circulo 2 es mas grande que el circulo 1 en area");
			break;
		case 0:
			System.out.println("Circulo 1 es igual que el circulo 2 en area");
			break;
		case 1:
			System.out.println("Circulo 1 es mas grande que el circulo 2 en area");
		}
		
		System.out.println("Circulo 1 => [<area>="+circ1.calcularArea()+", <diametro>="+circ1.calcularDiametro()+", <longitud>="+circ1.calcularLongitud()+"]");
		System.out.println("Indica los coordenadas del punto P (x, y) centro de un nuevo circulo ");
		
		double x=entrada.nextDouble();
		double y=entrada.nextDouble();
		System.out.println("Introduce el valor del radio del nuevo circulo");
		double radio=entrada.nextDouble();
		Circulo circ5=new Circulo(x,y,radio);
		System.out.println("Circulo 5 "+ circ5.toString());
		System.out.println("Circulo 5 => [<area>="+circ5.calcularArea()+", <diametro>="+circ5.calcularDiametro()+", <longitud>="+circ5.calcularLongitud()+"]");
		System.out.println("El numero de circulos creados es "+Circulo.getNumCirculos());
		
	
		
		entrada.close();
	}
}

