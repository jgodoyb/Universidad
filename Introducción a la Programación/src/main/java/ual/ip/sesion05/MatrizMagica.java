package org.ip.sesion05;

import java.util.Scanner;

public class MatrizMagica {
	
	private static Scanner entrada;
	

	public static void main(String[] args) {
		boolean valor;

		entrada=new Scanner(System.in);
		int[][]matriz= new int[4][4];
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				System.out.print("M["+i+"]["+j+"]: ");
				matriz[i][j]=entrada.nextInt();

			}
		}
		
		valor=esMatrizMagica(matriz);
		if(valor==true) {
			System.out.print("La matriz es magica");
		}else 
			System.out.println("La matriz no es magica");
		
	}
	
	public static boolean esMatrizMagica(int [][] matriz) {
		boolean magica1=false;
		boolean magica2=false;
		int[]b=new int[4];
		int[]c=new int[4];
		int cont=0;
		int cont2=0;
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				cont+=matriz[i][j];	
			}
			b[i]=cont;
			cont=0;
		}
		if(b[0]==b[1]&& b[0]==b[2] && b[0]==b[3]) {
			magica1=true;
		}
		
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				cont2+=matriz[j][i];
			}
			c[i]=cont2;
			cont2=0;
		}
		if(c[0]==c[1] && c[0]==c[2] && c[0]==c[3]) {
			magica2=true;
		}
		if(magica1&&magica2) {
			return true;
		}
		else
			return false;
		
		
		}
	
		
	}

