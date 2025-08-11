package org.ip.sesion03;

import java.util.Scanner;

public class Primo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner pant=new Scanner(System.in);
		int x;
		boolean primo;
		primo=true;
		
		do {
			System.out.print("Introduce un numero (>1) para saber si es primo: ");
			x=pant.nextInt();
		 }while(x<=1);
		
		for(int i=2;i<x;i++) {
			if(x%i==0) {
				primo=false;
				i=x+1;
			}else
				primo=true;
	
		}
		if(primo==true) {
			System.out.println("ES PRIMO");	
		}else
			System.out.println("NO ES PRIMO");
		
		pant.close();		
	}

}