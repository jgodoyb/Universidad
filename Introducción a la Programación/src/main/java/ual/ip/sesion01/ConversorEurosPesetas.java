package org.ip.sesion01;

public class ConversorEurosPesetas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double euros;
		int pesetas;
		
		euros=133.25;
		pesetas= (int)(euros*166.386);
		System.out.printf("%.2f euros => %d pesetas", + euros,pesetas);
		System.out.println();
		
		pesetas=3247;
		euros=pesetas/166.386;
		System.out.printf("%d pesetas => %.2f euros", +pesetas,euros);
		
	

			}

}
