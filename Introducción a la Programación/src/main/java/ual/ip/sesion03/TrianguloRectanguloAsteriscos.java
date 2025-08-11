package org.ip.sesion03;

public class TrianguloRectanguloAsteriscos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=9;
		
		System.out.println("Triangulo rectangulo de asteriscos de lado "+x+"\n");
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<x-i;j++) {
				System.out.print("* ");
				
			}
			System.out.println();
		}

	}

}
