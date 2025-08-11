package org.ip.sesion04;

import java.util.Scanner;

public class Sumatoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner pant=new Scanner(System.in);
		int x;
		System.out.println("Introduce el numero de terminos que desea sumar ");
		x=pant.nextInt();
		System.out.println();
		System.out.println("La suma usando el metodo iterativo de los "+x+" primeros numeros es "+Sumatoria.sumaIterativa(x));
		System.out.println("La suma usando el metodo directo de los "+x+" primeros numeros es "+Sumatoria.sumaDirecta(x));
		System.out.println("La suma usando el metodo recursivo de los "+x+" primeros numeros es "+Sumatoria.sumaRecursiva(x));
		System.out.println();
		if(Sumatoria.sumaIterativa(x)==Sumatoria.sumaDirecta(x) && Sumatoria.sumaRecursiva(x)==Sumatoria.sumaDirecta(x)){
			System.out.println("Funcionamiento correcto");	
		}else
			System.out.println("Funcionamiento NO correcto");
		pant.close();
	}
	public static int sumaIterativa(int x) {
		int cont=1;
		int suma=0;
		if(x==0) {
			cont=0;
		}else
			for(int i=1;x>i;x--) {
				suma=i*x;
				cont+=suma;
			
		}return cont;	
	}
	
	public static int sumaDirecta(int x) {
		return ((x*(x+1))/2);
		
	}
	public static int sumaRecursiva(int x) {
		if(x==0) {
		return 0;
		}else
			return x +Sumatoria.sumaRecursiva(x-1);
		
		
	}
	
}

