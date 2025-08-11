package org.ip.sesion03;

import java.util.Scanner;

public class TablaMultiplicar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner pant=new Scanner(System.in);
		int x=0;
		
		do {
			System.out.print("Introduduzca un numero (de 1 a 10): ");
			x=pant.nextInt();
			
		}while(x<=0 || x>=11);
		System.out.println();
		System.out.println("Tabla del "+x);
		for(int i=1;i<=10;i++) {
			System.out.println(x+" x "+i+" = "+i*x);
		}
	pant.close();
	
	}
	

}