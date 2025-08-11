package org.ip.sesion03;

import java.util.Scanner;

public class Euclides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner pant=new Scanner(System.in);
		int x,y,r,mcd	;
		x=0;
		y=0;
		r=1;
		mcd=0;
	
		do {
			System.out.println("Introduce el primer valor entero positivo");
			x=pant.nextInt();
		}while(x<1);
		
		do {
			System.out.println("Introduce el segundo valor entero positivo");
			y=pant.nextInt();
		}while(y<1);
		
		int x1=x;
		int y1= y;
		
		do {
			
			r=x1%y1;
			mcd=y1;
			x1=y1;
			y1=r;
			
		}while(r!=0);
		System.out.print("El MCD de "+x+" y "+y+" es "+mcd);
		
		pant.close();
	}

}