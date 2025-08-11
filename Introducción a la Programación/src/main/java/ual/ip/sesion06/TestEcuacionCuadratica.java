package org.ip.sesion06;

import java.util.Scanner;

public class TestEcuacionCuadratica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a,b,c;
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce los valores de los coeficinetes de la \necuacion cuadratica: ax*x + b*x + c = 0");
		System.out.print("a = ");
		a=entrada.nextDouble();
		System.out.print("b = ");
		b=entrada.nextDouble();
		System.out.print("c = ");
		c=entrada.nextDouble();
		EcuacionCuadratica ec1= new EcuacionCuadratica(a,b,c);
		System.out.println("Ecuacion Cuadratica: (a="+a+", b="+b+", c="+c+")");
		if(ec1.getA()==0) {
			System.out.println("No es una ecuacion cuadratica");
		}
		if(ec1.getDiscriminante()<0) {
			System.out.println("Ecuacion cuadratica sin raices reales");
		}
		if(ec1.getRaiz1()==ec1.getRaiz2()) {
			System.out.println("Ecuacion cuadratica con una unica raiz de valor doble");
			System.out.println("x = "+ec1.getRaiz1());
		}
		if(ec1.getRaiz1()!=ec1.getRaiz2() && ec1.getDiscriminante()>0 && ec1.getA()!=0) {
			System.out.println("Ecuacion cuadratica con dos raices de valores");
			System.out.println("x1 = "+ec1.getRaiz1()+"\nx2 = "+ec1.getRaiz2());
		}
		
		


		entrada.close();
		

	}

}
