package org.ip.sesion02;

public class SegundoSiguiente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int hora,minuto,segundo;
		hora=21;
		minuto=5;
		segundo=00;
		
		System.out.printf("%-38s: %02d:%02d:%02d", "Instante de tiempo actual", hora,minuto,segundo);
		System.out.println();
		segundo++;
		 
			if(segundo==60) {
				segundo=0;
				minuto++;}
			
			if(minuto==60) {
				hora++;
				minuto=0;
			}
			if(hora==24) {
				hora=0;
			}
			
			if(hora>=25 || minuto>60 || segundo>60 ) {
				System.out.println("Instante de tiempo un segundo despues : DATOS ERRONEOS");
			}
			else
				System.out.printf("%-38s: %02d:%02d:%02d", "Instante de tiempo un segundo despues", hora, minuto, segundo);
		      
		
	}
	

}
