package org.ip.sesion03;

public class TrianguloRectanguloNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=10;
		System.out.println("Triangulo rectangulo de numeros para un valor de lado = "+x);
		
		for(int i=0;i<x;i++){
			for(int j=0;j<x-i;j++){
				System.out.print("  ");
				
			}
			for(int k=0;k<i+1;k++) {
				
				System.out.print(i-k+" ");
			}
			System.out.println();
		}

	}

}