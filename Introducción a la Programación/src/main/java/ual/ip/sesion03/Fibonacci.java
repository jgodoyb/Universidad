package org.ip.sesion03;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner pant= new Scanner(System.in);
		
		int x=0;
		int y=1;
		int z=0;
		int i=1;
		
		System.out.println("Hasta que termino de la serie de Fibonacci quieres mostrar?");
        int n=pant.nextInt();
		
		if(n==0) {
			System.out.print("0");
		}
		if(n==1) {
			System.out.print("0\t1");
		}
		if(i<n) {
			System.out.print("0\t1\t");
			while(i<n) {
				z=x+y;
				System.out.print(z+"\t");
			
				x=y;
				y=z;
				i++;
		}
		}
		pant.close();
			}
		
			}