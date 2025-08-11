package org.ip.sesion03;

public class CuadradoAsteriscos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x=7;
		
		System.out.println("Cuadrado de asteriscos de lado "+x);
		System.out.println();
		for(int i=0;i<x;i++) {
			for(int j=0;j<x;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
