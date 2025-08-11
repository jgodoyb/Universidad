package org.ip.sesion04;

import java.util.Scanner;

public class Cilindro {

	public static void areaVolumenCilindro(double radio,double altura,int opcion) {
		if(opcion==1) {
			System.out.println("El area del cilindro es de: "+2*Math.PI*radio*(altura+radio));
		}else
			System.out.println("El volumen del cilindro es de: "+Math.PI*Math.pow(radio, 2)*altura);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner pant= new Scanner(System.in);
		double radio,altura;
		int opcion;
		do {
			System.out.print("Introduzca radio: ");
			radio=pant.nextDouble();
			System.out.print("Introduzca altura: ");
			altura=pant.nextDouble();
			System.out.print("Que desea calcular(1 (area) / 2 (volumen): ");
			opcion=pant.nextInt();
			System.out.println();
			if(opcion !=1 && opcion !=2) {
				System.out.println("ELIGE UNA OPCION POSIBLE");
			}else 
				Cilindro.areaVolumenCilindro(radio, altura, opcion);

		}while(opcion !=1 && opcion !=2);
		pant.close();
	}

}
